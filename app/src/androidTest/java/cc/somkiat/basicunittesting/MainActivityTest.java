package cc.somkiat.basicunittesting;

import android.support.test.espresso.Root;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void saveCorrectNameAndEmail() {
        closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(replaceText("Taweewong Tocharoen"));
        onView(withId(R.id.emailInput)).perform(replaceText("taweewong.t@gmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void saveWithEmptyName() {
        closeSoftKeyboard();
        onView(withId(R.id.emailInput)).perform(replaceText("taweewong.t@gmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Name is empty")).inRoot(getToastView()).check(matches(isDisplayed()));
    }

    @Test
    public void saveWithEmptyEmail() {
        closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(replaceText("Taweewong Tocharoen"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Email is empty")).inRoot(getToastView()).check(matches(isDisplayed()));
    }

    @Test
    public void saveWithInvalidName() {
        closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(replaceText("oat123 eiei inw za 007"));
        onView(withId(R.id.emailInput)).perform(replaceText("taweewong.t@gmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Name Pattern is incorrect")).inRoot(getToastView()).check(matches(isDisplayed()));
    }

    @Test
    public void saveWithInvalidEmail() {
        closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(replaceText("Taweewong Tocharoen"));
        onView(withId(R.id.emailInput)).perform(replaceText("taweewong.t"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText("Email Pattern is incorrect")).inRoot(getToastView()).check(matches(isDisplayed()));
    }

    @Test
    public void revertButtonTest() {
        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }

    private Matcher<Root> getToastView() {
        return withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())));
    }
}
