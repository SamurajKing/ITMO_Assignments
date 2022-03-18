package hw7_markup;

public interface Markdownable extends Htmlable {
    void toMarkdown(StringBuilder res);
}
