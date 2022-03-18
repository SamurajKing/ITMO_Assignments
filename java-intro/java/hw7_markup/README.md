# Тесты к курсу «Введение в программирование»

[Условия домашних заданий](https://www.kgeorgiy.info/courses/prog-intro/homeworks.html)


## Домашнее задание 7. Разметка

Исходный код тестов:

 * [MarkdownTest.java](java/markup/MarkdownTest.java)
 * [AbstractTest.java](java/markup/AbstractTest.java)


## Домашнее задание 6. Подсчет слов++
Модификации:
 * *SortedSecondG* (38-39)
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Вместо номеров вхождений во всем файле надо указывать
      только четныe вхождения в каждой строке.
    * Класс должен иметь имя `hw6_wordstatpp.WsppSortedSecondG`
    * [Исходный код тестов](java/wspp/WsppSortedSecondGTest.java)
    * [Откомпилированные тесты](artifacts/wspp/WsppSortedSecondGTest.jar)
 * *SecondG* (36-37)
    * Вместо номеров вхождений во всем файле надо указывать
      только четныe вхождения в каждой строке.
    * Класс должен иметь имя `WsppSecondG`
    * [Исходный код тестов](java/wspp/WsppSecondGTest.java)
    * [Откомпилированные тесты](artifacts/wspp/WsppSecondGTest.jar)
 * *SortedPosition* (34-35)
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Вместо номеров вхождений во всем файле надо указывать
      `<номер строки>:<номер в строке>`
    * Класс должен иметь имя `WsppSortedPosition`
    * [Исходный код тестов](java/wspp/WsppSortedPositionTest.java)
    * [Откомпилированные тесты](artifacts/wspp/WsppSortedPositionTest.jar)
 * *Position* (31-33)
    * Вместо номеров вхождений во всем файле надо указывать
      `<номер строки>:<номер в строке>`
    * Класс должен иметь имя `WsppPosition`
    * [Исходный код тестов](java/wspp/WsppPositionTest.java)
    * [Откомпилированные тесты](artifacts/wspp/WsppPositionTest.jar)

Исходный код тестов:

* [WordStatTest.java](java/wspp/WsppTest.java)
* [WordStatIndexChecker.java](java/wspp/WsppChecker.java)

Откомпилированные тесты: [WordStatTest.jar](artifacts/wspp/WsppTest.jar)


## Домашнее задание 5. Свой сканнер

Модификации
 * *HexAbc2* (38-39)
    * На вход подаются десятичные и шестнадцатеричные числа
    * Шестнадцатеричные числа имеют префикс `0x`
    * Десятеричные числа могут быть записаны буквами 
      нулю соответствует буква `a`, единице – `b` и так далее
    * Выведите все числа, используя буквенный формат
    * Класс должен иметь имя `ReverseHexAbc2`
    * [Исходный код тестов](java/reverse/FastReverseHexAbc2Test.java)
    * [Откомпилированные тесты](artifacts/reverse/FastReverseHexAbc2Test.jar)
 * *Linear* (38-39)
    * Пусть _n_ – сумма числа чисел и строк во входе,
      тогда программе разрешается потратить не более 5 _n_ +O(1) памяти
 * *HexDec2* (36-37)
    * На вход подаются десятичные и шестнадцатеричные числа
    * Шестнадцатеричные числа имеют префикс `0x`
    * Выведите все числа, используя формат шестнадцатеричных чисел
    * Класс должен иметь имя `ReverseHexDec2`
    * [Исходный код тестов](java/reverse/FastReverseHexDec2Test.java)
    * [Откомпилированные тесты](artifacts/reverse/FastReverseHexDec2Test.jar)
 * *Hex2* (34-35)
    * Во вводе используются числа в шестнадцатеричной системе счисления
    * Класс должен иметь имя `ReverseHex2`
    * [Исходный код тестов](java/reverse/FastReverseHex2Test.java)
    * [Откомпилированные тесты](artifacts/reverse/FastReverseHex2Test.jar)
 * *Abc2* (31-33)
    * Во вводе и выводе используются числа, записаные буквами:
      нулю соответствует буква `a`, единице – `b` и так далее
    * Класс должен иметь имя `ReverseAbc2`
    * [Исходный код тестов](java/reverse/FastReverseAbc2Test.java)
    * [Откомпилированные тесты](artifacts/reverse/FastReverseAbc2Test.jar)


Исходный код тестов:

* [FastReverseTest.java](java/reverse/FastReverseTest.java)

Откомпилированные тесты: [FastReverseTest.jar](artifacts/reverse/FastReverseTest.jar)


## Домашнее задание 4. Подсчет слов

Модификации
 * *Count* (34, 35, 38, 39)
    * В выходном файле слова должны быть упорядочены по возрастанию числа
      вхождений, а при равном числе вхождений – по порядку первого вхождения
      во входном файле.
    * Класс должен иметь имя `WordStatCount`
    * [Исходный код тестов](java/wordStat/WordStatCountTest.java)
    * [Откомпилированные тесты](artifacts/wordStat/WordStatCountTest.jar)
 * *Words* (31, 32, 33, 36, 37)
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Класс должен иметь имя `WordStatWords`
    * [Исходный код тестов](java/wordStat/WordStatWordsTest.java)
    * [Откомпилированные тесты](artifacts/wordStat/WordStatWordsTest.jar)
 * *Sort* (36-39)
    * Пусть _n_ – число слов во входном файле,
      тогда программа должна работать за O(_n_ log _n_).

Исходный код тестов:

* [WordStatInputTest.java](java/wordStat/WordStatInputTest.java)
* [WordStatChecker.java](java/wordStat/WordStatChecker.java)

Откомпилированные тесты: [WordStatInputTest.jar](artifacts/wordStat/WordStatInputTest.jar)


## Домашнее задание 3. Реверс

Модификации
 * *Sum2* (38, 39)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите сумму чисел 
      в прямоугольнике верхний левый угол матрицы — текущее число
    * Класс должен иметь имя `ReverseSum2`
    * [Исходный код тестов](java/reverse/ReverseSum2Test.java)
    * [Откомпилированные тесты](artifacts/reverse/ReverseSum2Test.jar)
 * *Min2* (36, 37)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите минимум из чисел 
      верхний левый угол матрицы — текущее число
    * Класс должен иметь имя `ReverseMin2`
    * [Исходный код тестов](java/reverse/ReverseMin2Test.java)
    * [Откомпилированные тесты](artifacts/reverse/ReverseMin2Test.jar)
 * *Linear* (36-39)
    * Пусть _n_ – сумма числа чисел и строк во входе,
      тогда программе разрешается потратить не более 6_n_+O(1) памяти
 * *Transpose* (34-35)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      выведите ее в транспонированном виде
    * Класс должен иметь имя `ReverseTranspose`
    * [Исходный код тестов](java/reverse/ReverseTransposeTest.java)
    * [Откомпилированные тесты](artifacts/reverse/ReverseTransposeTest.jar)
 * *Odd2* (31-33)
    * Выведите (в реверсивном порядке) только числа, 
      у которых сумма номеров строки и столбца нечетная
    * Класс должен иметь имя `ReverseOdd2`
    * [Исходный код тестов](java/reverse/ReverseOdd2Test.java)
    * [Откомпилированные тесты](artifacts/reverse/ReverseOdd2Test.jar)


Исходный код тестов:

* [ReverseTest.java](java/reverse/ReverseTest.java)
* [ReverseChecker.java](java/reverse/ReverseChecker.java)

Откомпилированные тесты: [ReverseTest.jar](artifacts/reverse/ReverseTest.jar)


## Домашнее задание 2. Сумма чисел

Модификации
 * *BigIntegerHex* (38-39)
    * Входные данные помещаются в тип [BigInteger](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigInteger.html)
    * Шестнадцатеричные числа имеют префикс `0x`
    * Класс должен иметь имя `SumBigIntegerHex`
    * [Исходный код тестов](java/sum/SumBigIntegerHexTest.java)
    * [Откомпилированные тесты](artifacts/sum/SumBigIntegerHexTest.jar)
 * *LongHex* (36-37)
    * Входные данные являются 64-битными целыми числами
    * Шестнадцатеричные числа имеют префикс `0x`
    * Класс должен иметь имя `SumLongHex`
    * [Исходный код тестов](java/sum/SumLongHexTest.java)
    * [Откомпилированные тесты](artifacts/sum/SumLongHexTest.jar)
 * *Float* (34-35)
    * Входные данные являются 32-битными числами с формате с плавающей точкой
    * Класс должен иметь имя `SumFloat`
    * Числа разделяются [пробелами-разделителями](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#SPACE_SEPARATOR)
    * [Исходный код тестов](java/sum/SumFloatTest.java)
    * [Откомпилированные тесты](artifacts/sum/SumFloatTest.jar)
 * *Long* (31-33)
    * Входные данные являются 64-битными целыми числами
    * Класс должен иметь имя `SumLong`
    * [Исходный код тестов](java/sum/SumLongTest.java)
    * [Откомпилированные тесты](artifacts/sum/SumLongTest.jar)



Для того, чтобы протестировать исходную программу:

 1. Скачайте откомпилированные тесты ([SumTest.jar](artifacts/sum/SumTest.jar))
 1. Откомпилируйте `Sum.java`
 1. Проверьте, что создался `Sum.class`
 1. В каталоге, в котором находится `Sum.class` выполните команду
    ```
       java -jar <путь к SumTest.jar>
    ```
    * Например, если `SumTest.jar` находится в текущем каталоге, выполните команду
    ```
        java -jar SumTest.jar
    ```

Исходный код тестов:

* [SumTest.java](java/sum/SumTest.java)
* [SumChecker.java](java/sum/SumChecker.java)
* [Базовые классы](java/base/)


## Домашнее задание 1. Запусти меня!

Модификации
  * *RunMe*
    1. Скачайте исходный код ([RunMe.java](java/RunMe.java))
    1. Создайте скрипт, компилирующий и запускающий `RunMe` из командной строки 
       с выданными вам аргументами командной строки
    1. Следуйте выведенной инструкции

Рекомендации по выполнению модификации
  1. Проверьте версию Java:
    1. Запустите `javac --version` и проверьте, что версия 
       находится в диапазоне 11..17.
    1. Запустите `java --version` и проверьте, что версия 
       такая же как и у `javac`.
  1. Скачайте [RunMe.java](java/RunMe.java)
  2. Откомпилируйте `RunMe.java`:
    1. Запустите `javac RunMe.java`
    1. Убедитесь, что компиляция завершилась бе ошибок
    1. Проверьте, что появился `RunMe.class`
  3. Запустите `RunMe`:
    1. Запустите `java RunMe [шесть] [слов] [пароля] [пришедшего] [на] [email]`
    1. При правильном исполнении вы должны получить ссылку
       Если получено сообщение об ошибке — исправьте её и запустите повторно
    1. Зайдите по полученной ссылке и убедитесь, что она правильная
  4. Напишите и протестируйте скрипт:
    1. Напишите скрипт, включающий команды компиляции и запуска. 
       Если вы не умеете писать скрипты, во воспользуйтесь одной из инструкций:
       [Windows](https://www.windowscentral.com/how-create-and-run-batch-file-windows-10),
       [Linux](https://linuxhint.com/write_simple_bash_script/),
       [macOS](https://www.hastac.org/blogs/joe-cutajar/2015/04/21/how-make-simple-bash-script-mac)
    1. Запустите и проверьте, что вы получили ту же ссылку, что и в предыдущем пункте
    1. Сдайте скрипт преподавателю
  5. Вы можете получить больше плюсиков, модифицируя код `RunMe.java`
