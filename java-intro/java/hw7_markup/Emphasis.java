package hw7_markup;

import java.util.List;

public class Emphasis extends MarkdownElement implements Content {

    public Emphasis(List<Content> list) {
        super(list);
    }

    @Override
    public String getBorder() {
        return "*";
    }

    @Override
    public String getOpenTag() {
        return "<em>";
    }

    @Override
    public String getCloseTag() {
        return "</em>";
    }
}
