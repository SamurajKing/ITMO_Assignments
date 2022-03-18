package hw7_markup;

import java.util.List;

public class Insert extends MarkdownElement implements Content {
    public Insert(List<Content> list) {
        super(list);
    }

    @Override
    public String getBorder() {
        return "__";
    }

    @Override
    public String getOpenTag() {
        return "<ins>";
    }

    @Override
    public String getCloseTag() {
        return "</ins>";
    }
}
