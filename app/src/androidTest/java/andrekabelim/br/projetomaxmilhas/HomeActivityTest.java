package andrekabelim.br.projetomaxmilhas;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import andrekabelim.br.projetomaxmilhas.ui.view.HomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity>
            mActivityRule = new ActivityTestRule<>(HomeActivity.class, false, true);

    @Test
    public void executarFiltro(){

        onView(withId(R.id.edt_source_iata)).perform(setTextInTextView("ANDRE"));

        onView(withId(R.id.btn_find_tickets)).perform(click());
    }

    @Test
    public void validarDados(){

        onView(withId(R.id.btn_find_tickets)).perform(click());

        onView(withId(R.id.edt_source_iata)).perform(setTextInTextView("Aeroporto Confins"), closeSoftKeyboard());

        onView(withId(R.id.btn_find_tickets)).perform(click());

        onView(withId(R.id.btn_find_tickets)).perform(click());

        onView(withId(R.id.edt_destination_iata)).perform(setTextInTextView("Aeroporto Confins"), closeSoftKeyboard());

        onView(withId(R.id.btn_find_tickets)).perform(click());

        onView(withId(R.id.btn_find_tickets)).perform(click());

        onView(withId(R.id.edt_date_from)).perform(setTextInTextView("20/09/2018"), closeSoftKeyboard());

        onView(withId(R.id.btn_find_tickets)).perform(click());

        onView(withId(R.id.edt_date_to)).perform(setTextInTextView("19/09/2018"), closeSoftKeyboard());

        onView(withId(R.id.btn_find_tickets)).perform(click());

        onView(withId(R.id.btn_find_tickets)).perform(click());
    }

    public static ViewAction setTextInTextView(final String value){
        return new ViewAction() {
            @SuppressWarnings("unchecked")
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), isAssignableFrom(TextView.class));
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((TextView) view).setText(value);
            }

            @Override
            public String getDescription() {
                return "replace text";
            }
        };
    }
}
