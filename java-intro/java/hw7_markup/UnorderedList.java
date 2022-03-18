package hw7_markup;

import java.util.List;

public class UnorderedList extends HtmlElement implements ListItemContent {

    public UnorderedList(List<ListItem> list) {
        super(list);
    }

    @Override
    public String getOpenTag() {
        return "<ul>";
    }

    @Override
    public String getCloseTag() {
        return "</ul>";
    }
}
