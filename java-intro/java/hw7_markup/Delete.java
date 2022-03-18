package hw7_markup;

import java.util.List;

public class Delete extends MarkdownElement implements Content {
    public Delete(List<Content> list) {
        super(list);
    }

    @Override
    public String getBorder() {
        return "__";
    }

    @Override
    public String getOpenTag() {
        return "<del>";
    }

    @Override
    public String getCloseTag() {
        return "</del>";
    }
}
