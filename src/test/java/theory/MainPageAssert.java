package theory;

import org.assertj.core.api.AbstractAssert;
import static com.codeborne.selenide.Condition.visible;

public class MainPageAssert extends AbstractAssert<MainPageAssert,MainPage > {
    public MainPageAssert(MainPage actual){
        super(actual,MainPageAssert.class);
    }

    public MainPageAssert cartButtonIsVisible(){
        actual.cartButton.should(visible);

        return this;
    }
}

