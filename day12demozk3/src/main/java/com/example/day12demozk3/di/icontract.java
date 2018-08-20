package com.example.day12demozk3.di;

/**
 * Created by lenovo on 2018/8/19.
 */

public interface icontract {
    /**
     * iview层
     */
    public  interface  iview{
        void  showdata(String s);
    }
    /**
     * ipresenter层
     */
    public  interface  ipresenter<iview>{
        void  attachview(iview iview);
        void  detachview(iview iview);
        void  requestinfo();
    }
    /**
     * imoudle层
     */
    public  interface  imoudel{
         public  interface calllistten{
             void  responsemsg(String s);
         }
         void  response(calllistten calllistten);
    }

}
