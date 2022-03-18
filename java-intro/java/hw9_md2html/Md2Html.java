package hw9_md2html;
import hw7_markup.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//
//`фелфввz--eрюс **хξμε *αηοx*ι**
//ят--
//ид`x.setLength(0);
//ηφηŋυεŋκξβ --φлэ`υλνομω *qgэ**ецhζ**s* cb` ey--bdg

public class Md2Html {
    public static void main(String[] args) {
        String inFile = args[0];
        String outFile = args[1];
        List<String> have = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        try ( BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inFile),
                        "utf8"
                )
        );) {
            while (true) {
                String s = in.readLine();
                if (s == null) {
                    break;
                }
                have.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        have.add(""); //чтобы добавить последний параграф автоматически
        List<Paragraph> par = new ArrayList<>();
        for (String s : have) {
            if (s.isEmpty()) {
                if (!tmp.isEmpty()) {
                    tmp.deleteCharAt(tmp.length() - 1);
                    int i = 0;
                    while (i < tmp.length() && tmp.charAt(i) == '#') {
                        ++i;
                    }
                    if (i > 0 && tmp.charAt(i) == ' ') {
                        tmp.delete(0, i + 1);
                    } else {
                        i = 0;
                    }
                    par.add(new Paragraph(recur(tmp.toString()), i));
                    tmp.setLength(0);
                }
            } else {
                tmp.append(s);
                tmp.append('\n');
            }
        }
        StringBuilder answer = new StringBuilder();
        for (Paragraph p : par) {
            p.toHtml(answer);
            answer.append('\n');
        }

        try ( BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(outFile),
                        "utf8"
                )
        );) {
            out.write(answer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Content> recur(String text) {
        List<Content> list = new ArrayList<>();
        int i = 0;
        int n = text.length();
        StringBuilder tmp = new StringBuilder();
        StringBuilder simpleText = new StringBuilder();
        while (i < n) {
            char current = text.charAt(i);
            char next = i + 1 < n ? text.charAt(i + 1) : '?';
            char[] open = {'*', '_', '-', '<', '}'};
            char[] close = {'*', '_', '-', '>', '{'};
            boolean other = true;
            for (int j = 0; j < 5; ++j) {
                if (i + 1 < n && current == open[j] && next == open[j]) {
                    other = false;
                    if (!simpleText.isEmpty()) {
                        list.add(new Text(simpleText.toString()));
                        simpleText.setLength(0);
                    }
                    i += 2;
                    while (i < n && !(text.charAt(i) == close[j] && (i + 1 < n
                            && text.charAt(i + 1) == close[j]))) {
                        tmp.append(text.charAt(i++));
                    }
                    i += 2;
                    List<Content> addList = recur(tmp.toString());
                    list.add(getElement(j, addList));
                    tmp.setLength(0);
                }
            }
            char[] one = {'*', '_', '`'};
            for (int j = 0; j < 3; ++j) {
                if (!other) continue;
                if (i + 1 < n && current == one[j] && next != ' ' && next != '\n') {
                    other = false;
                    if (!simpleText.isEmpty()) {
                        list.add(new Text(simpleText.toString()));
                        simpleText.setLength(0);
                    }
                    i++;
                    while (i < n && text.charAt(i) != one[j]) {
                        tmp.append(text.charAt(i++));
                        if (i + 1 < n && text.charAt(i) == close[j]
                                && text.charAt(i + 1) == close[j]) {
                            tmp.append(close[j]);
                            tmp.append(close[j]);
                            i += 2;
                        }
                    }
                    i++;
                    List<Content> addList = recur(tmp.toString());
                    list.add(getOneElement(j, addList));
                    tmp.setLength(0);
                }
            }
            if (other) {
                if (i + 1 < n && current == '\\') {
                    simpleText.append(ekr(next));
                    i += 2;
                    continue;
                }
                simpleText.append(ekr(current));
                i++;
            }
        }
        if (!simpleText.isEmpty()) {
            list.add(new Text(simpleText.toString()));
        }
        return list;
    }

    public static Content getElement(int j, List<Content> addList) {
        if (j == 0 || j == 1) {
            return new Strong(addList);
        } else if (j == 2) {
            return new Strikeout(addList);
        } else if (j == 3) {
            return new Insert(addList);
        } else if (j == 4) {
            return new Delete(addList);
        }
        return null;
    }

    public static Content getOneElement(int j, List<Content> addList) {
        if (j == 0 || j == 1) {
            return new Emphasis(addList);
        } else if (j == 2) {
            return new Code(addList);
        }
        return null;
    }

    public static String ekr(char c) {
        if (c == '<') {
            return "&lt;";
        } else if (c == '>') {
            return "&gt;";
        } else if (c == '&') {
            return "&amp;";
        } else {
            return String.valueOf(c);
        }
    }
}
