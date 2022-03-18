package hw7_markup;

import java.util.List;

public class ListItem extends HtmlElement {

    public ListItem(List<ListItemContent> list) {
        super(list);
    }

    @Override
    public String getOpenTag() {
        return "<li>";
    }

    @Override
    public String getCloseTag() {
        return "</li>";
    }
}
