package hw7_markup;

import java.util.List;

public class Strong extends MarkdownElement implements Content {
    public Strong(List<Content> list) {
        super(list);
    }

    @Override
    public String getBorder() {
        return "__";
    }

    @Override
    public String getOpenTag() {
        return "<strong>";
    }

    @Override
    public String getCloseTag() {
        return "</strong>";
    }
}
