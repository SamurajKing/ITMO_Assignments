package hw7_markup;

public class Text implements Markdownable, Content {
    private final String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public void toMarkdown(StringBuilder res) {
        res.append(getText());
    }

    @Override
    public void toHtml(StringBuilder res) {
        res.append(getText());
    }

}
