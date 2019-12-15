package cn.yejh.transaction.service.impl;

import cn.yejh.transaction.dao.impl.AccountDaoImpl;
import cn.yejh.transaction.entity.Account;
import cn.yejh.transaction.service.AccountService;
import org.junit.Test;
import org.student.util.JDBCUtil;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    AccountDaoImpl accountDao = new AccountDaoImpl();

    @Override
    public void transfer(int fromCardId, int toCardId, int money) {
        try {
            JDBCUtil.beginTransaction();
            Account fromAccount = accountDao.queryAccountByCard(fromCardId);
            Account toAccount = accountDao.queryAccountByCard(toCardId);
            if(fromAccount.getBalance() > money){
                //转入账户有足够余额，可以进行下一步转账
                fromAccount.setBalance(fromAccount.getBalance() - money);
                toAccount.setBalance(toAccount.getBalance() + money);
                //System.out.println(1/0);
                accountDao.updateAccount(fromAccount);
                accountDao.updateAccount(toAccount);
                System.out.println("转账成功!");

                //完成事务
                JDBCUtil.commitTransaction();
            }else{
                //转入账户余额不足，不能转账
                System.out.println("余额不足！");
            }
        } catch (Exception e) {
            //收集所有异常
            try {
                JDBCUtil.rollbackTransaction();
                System.out.println("转账失败，回滚操作！");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            //最后要关闭connection
            try {
                JDBCUtil.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void transferTest(){
        transfer(1, 2, 1000);
    }

}
