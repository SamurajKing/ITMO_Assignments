package hw7_markup;

import java.util.List;

public abstract class MarkdownElement extends Element implements Markdownable {

    public MarkdownElement(List<Content> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder res) {
        res.append(getBorder());
        for (Htmlable it : list) {
            ((Markdownable)it).toMarkdown(res);
        }
        res.append(getBorder());
    }

    public abstract String getBorder();
}
