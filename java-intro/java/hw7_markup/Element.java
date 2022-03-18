package hw7_markup;

import java.util.ArrayList;
import java.util.List;

public abstract class Element implements Htmlable {
    protected final List<? extends Htmlable> list;

    public Element(List<? extends Htmlable> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public void toHtml(StringBuilder res) {
        res.append(getOpenTag());
        for (Htmlable it : list) {
            it.toHtml(res);
        }
        res.append(getCloseTag());
    }

    public abstract String getOpenTag();
    public abstract String getCloseTag();
}
