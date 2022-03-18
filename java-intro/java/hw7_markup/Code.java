package hw7_markup;


import java.util.List;

public class Code extends MarkdownElement implements Content {

    public Code(List<Content> list) {
        super(list);
    }

    @Override
    public String getOpenTag() {
        return "<code>";
    }

    @Override
    public String getCloseTag() {
        return "</code>";
    }

    @Override
    public String getBorder() {
        return "'";
    }
}
