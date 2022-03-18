package hw7_markup;

import java.util.List;

public abstract class HtmlElement extends Element {
    public HtmlElement(List<? extends Htmlable> list) {
        super(list);
    }
}
