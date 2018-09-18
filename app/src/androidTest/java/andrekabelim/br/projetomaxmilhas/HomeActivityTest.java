package andrekabelim.br.projetomaxmilhas;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import andrekabelim.br.projetomaxmilhas.ui.view.HomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity>
            mActivityRule = new ActivityTestRule<>(HomeActivity.class, false, true);

    @Test
    public void ExecutarFiltro(){

        onView(withId(R.id.edt_source_iata)).perform(typeText("ANDRE"), closeSoftKeyboard());

        onView(withId(R.id.btn_find_tickets)).perform(click());
    }
}
