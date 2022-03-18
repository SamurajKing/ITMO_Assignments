package hw7_markup;

import java.util.List;

public class Paragraph extends MarkdownElement implements ListItemContent {
    private int cnt = -1;
    public Paragraph(List<Content> list) {
        super(list);
    }
    public Paragraph(List<Content> list, int cnt) {
        super(list);
        this.cnt = cnt;
    }
    public List<?extends Htmlable> getContent() {
        return this.list;
    }
    @Override
    public String getOpenTag() {
        if (cnt == -1) {
            return "";
        } else if (cnt == 0) {
            return "<p>";
        } else {
            return "<h" + cnt + ">";
        }
    }

    @Override
    public String getCloseTag() {
        if (cnt == -1) {
            return "";
        } else if (cnt == 0) {
            return "</p>";
        } else {
            return "</h" + cnt + ">";
        }
    }

    @Override
    public String getBorder() {
        return "";
    }
}
