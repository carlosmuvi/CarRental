package com.carlosmuvi.carrental.rentalcarsearchform;

import android.app.Activity;
import com.carlosmuvi.carrental.navigator.Navigator;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.carlosmuvi.carrental.rentalcarsearchform.RentalCarSearchFormPresenter.View;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class RentalCarSearchFormPresenterTest {

    @Inject RentalCarSearchFormPresenter presenter;
    @Inject Navigator router;
    View view;

    @Before public void setup() {
        TestComponent component =
            DaggerRentalCarSearchFormPresenterTest_TestComponent.builder().testModule(new TestModule()).build();
        component.inject(this);

        view = Mockito.mock(View.class);
        presenter.setView(view);
    }

    @Test public void shouldShowErrorMessageIfSomeDatenHasNotBeenSelected() {
        presenter.onSubmitClicked(true, true, false, true, Mockito.mock(MutableDateTime.class),
            Mockito.mock(MutableDateTime.class), "LAX");

        // Show error message has been called at least once.
        verify(view, atLeastOnce()).showMessage(anyString());

        // No navigation to result list has taken place.
        verify(router, never()).navigateToCarRentalList(any(DateTime.class), any(DateTime.class), anyString());
    }

    @Singleton @Component(modules = TestModule.class) public interface TestComponent
        extends RentalCarSearchFormComponent {
        void inject(RentalCarSearchFormPresenterTest test);
    }

    @Module public class TestModule extends RentalCarSearchFormModule {

        @Provides Navigator providesNavigator() {
            return Mockito.mock(Navigator.class);
        }

        @Provides Activity providesActivity() {
            return Mockito.mock(Activity.class);
        }
    }
}