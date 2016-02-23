/**
 * Created by bod on 9/13/15.
 */
public class HelloRx {

//    public static void main(String[] string) {
//        System.out.println("DB-Test, hello Rx");
//
//        BehaviorSubject<Boolean> condition0 = BehaviorSubject.create(false);
//        BehaviorSubject<Boolean> condition1 = BehaviorSubject.create(false);
//        BehaviorSubject<Boolean> condition2 = BehaviorSubject.create(false);
//        BehaviorSubject<Boolean> condition3 = BehaviorSubject.create(false);
//
//        DataSource dataSource = new DataSource();
//
//        final Subscription subscription = dataSource.getUuidObservable().distinctUntilChanged()
//                .observeOn(Schedulers.newThread()).subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String uuid) {
//                        System.out.println("DB-Test uuid changed to : " + uuid);
//                    }
//                });
//
//        Observable<Boolean> observable = Observable.combineLatest(
//                condition0, condition1, condition2, condition3, new Func4<Boolean, Boolean, Boolean, Boolean, Boolean>() {
//                    @Override
//                    public Boolean call(Boolean aBoolean, Boolean aBoolean2, Boolean aBoolean3, Boolean aBoolean4) {
//                        return aBoolean && aBoolean2 && aBoolean3 && aBoolean4;
//                    }
//                }
//        );
//
//        final Subscription conditionsSubscription = observable.distinctUntilChanged()
//                .observeOn(Schedulers.newThread()).subscribe(new Action1<Boolean>() {
//            @Override
//            public void call(Boolean aBoolean) {
//                System.out.println("DB-Test condition changed to : " + aBoolean);
//            }
//        });
//
//        condition0.onNext(true);
//        condition1.onNext(true);
//        condition2.onNext(true);
//        condition3.onNext(true);
//
//        condition3.onNext(false);
//        condition2.onNext(false);
//
//        condition2.onNext(true);
//        condition3.onNext(true);
//
//        dataSource.setUuid(null);
//        dataSource.setUuid("123");
//        dataSource.setUuid("123");
//        dataSource.setUuid("345");
//        dataSource.setUuid("678");
//        dataSource.clear();
//        dataSource.setUuid("911");
//
//        int count = 0;
//        while (count ++ < 2) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        subscription.unsubscribe();
//
//        dataSource.setUuid("null");
//        dataSource.setUuid("111");
//
//        dataSource.getUuidObservable().last();
//
//        count = 0;
//        while (count ++ < 2) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("end");
//    }

}
