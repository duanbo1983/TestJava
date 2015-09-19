import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by bod on 9/13/15.
 */
public class HelloRx {

    public static void main(String[] string) {
        System.out.println("DB-Test, hello Rx");

        DataSource dataSource = new DataSource();

        final Subscription subscription = dataSource.getUuidObservable().distinctUntilChanged()
                .observeOn(Schedulers.newThread()).subscribe(new Action1<String>() {
            @Override
            public void call(String uuid) {
                System.out.println("DB-Test uuid changed to : " + uuid);
            }
        });

        dataSource.setUuid(null);
        dataSource.setUuid("123");
        dataSource.setUuid("123");
        dataSource.setUuid("345");
        dataSource.setUuid("678");
        dataSource.clear();
        dataSource.setUuid("911");

        int count = 0;
        while (count ++ < 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        subscription.unsubscribe();

        dataSource.setUuid("null");
        dataSource.setUuid("111");

        count = 0;
        while (count ++ < 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end");
    }

}
