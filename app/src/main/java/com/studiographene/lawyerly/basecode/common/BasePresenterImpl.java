package com.studiographene.lawyerly.basecode.common;

public abstract class BasePresenterImpl implements BasePresenter {



    @Override
    public void attachView(BaseView v) {

    }

    public abstract BaseView getView();


    @Override
    public void onDestroy() {


    }

    @Override
    public void onError(Throwable e) {

//        try {
//            Log.d("BasePresenter", "onError: " + e);
//
//            e.printStackTrace();
////        getView().showProgressBar(false);
//            getView().postErrorHandling();
//
//
//            if (e instanceof HttpException) {
//
//
//                Gson gson = new Gson();
//
//                BaseResponseData<BlankData> rideRequestGcmModel = gson.fromJson(((HttpException) e).response().errorBody().string(), BaseResponseData.class);
//
//
//                if (rideRequestGcmModel.getStatusCode() == 401) {
//                    getView().logout();
//                } else {
//                    getView().showSnackBar(rideRequestGcmModel.getMessage());
//                }
//
//
//            } else {
//
//                if (getView() != null) {
//                    getView().showSnackBar("Network Issue");
//                }
//
//            }
//
//        } catch (IOException e1) {
//
//            e1.printStackTrace();
//        }
    }
}
