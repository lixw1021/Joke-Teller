import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertTrue;

/**
 * Created by xianwei li on 10/4/2017.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    Context context;

    @Test
    public void testVerifyJoke() throws InterruptedException {
        assertTrue(true);
        final CountDownLatch latch = new CountDownLatch(1);
        context = InstrumentationRegistry.getContext();
        EndpointsAsyncTask testTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertTrue(!TextUtils.isEmpty(result));
                latch.countDown();
            }
        };
        testTask.execute(context);
        latch.await();
    }
}
