package com.example.day12demozk3.di;

import java.lang.ref.WeakReference;

/**
 * Created by lenovo on 2018/8/19.
 */

public class presenterimp implements  icontract.ipresenter<icontract.iview> {


    private WeakReference<icontract.iview> weakReference;
    private moudelimp moudelimp;
    private WeakReference<icontract.imoudel> weakReference1;
    private  icontract.iview iview;
    @Override
    public void attachview(icontract.iview iview) {
        this.iview=iview;
        moudelimp = new moudelimp();
        weakReference = new WeakReference<icontract.iview>(iview);
        weakReference1 = new WeakReference<icontract.imoudel>(moudelimp);
    }

    @Override
    public void detachview(icontract.iview iview) {
        weakReference.clear();
        weakReference1.clear();
    }

    @Override
    public void requestinfo() {
        moudelimp.response(new icontract.imoudel.calllistten() {
            @Override
            public void responsemsg(String s) {
                iview.showdata(s);
            }
        });
    }
}
