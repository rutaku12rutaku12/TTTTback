package 종합.과제5_1.controller;


import 종합.과제5_1.model.dao.WaitingDao;
import 종합.과제5_1.model.dto.WaitingDto;

public class WaitingController {
    private WaitingController(){}
    private static final WaitingController controller = new WaitingController();
    public static WaitingController getInstance(){
        return controller;
    }

    private WaitingDao waitingDao = WaitingDao.getInstance();

    public boolean addWaiting( String phone , int count ){
        boolean result = false;
        result = waitingDao.addWaiting( phone , count );
        return result;
    }
    public WaitingDto[] getWaitingLIst(){
        return waitingDao.getWaitingList();
    }
}
