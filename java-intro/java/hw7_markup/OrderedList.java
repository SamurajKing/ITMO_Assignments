package hw7_markup;

import java.util.List;

public class OrderedList extends HtmlElement implements ListItemContent {

    public OrderedList(List<ListItem> list) {
        super(list);
    }

    @Override
    public String getOpenTag() {
        return "<ol>";
    }

    @Override
    public String getCloseTag() {
        return "</ol>";
    }
}
