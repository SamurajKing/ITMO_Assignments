package hw7_markup;

import java.util.List;

public class Strikeout extends MarkdownElement implements Content {

    public Strikeout(List<Content> list) {
        super(list);
    }

    @Override
    public String getBorder() {
        return "~";
    }

    @Override
    public String getOpenTag() {
        return "<s>";
    }

    @Override
    public String getCloseTag() {
        return "</s>";
    }
}
