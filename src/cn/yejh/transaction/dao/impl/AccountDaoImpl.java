package cn.yejh.transaction.dao.impl;

import cn.yejh.transaction.dao.AccountDao;
import cn.yejh.transaction.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.student.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account queryAccountByCard(int cardId) throws SQLException {
        QueryRunner runner = new QueryRunner() ;
        Connection conn = JDBCUtil.getConnection() ;
        Account account = runner.query(conn, "select * from account where cardId = ?", new BeanHandler<Account>(Account.class), cardId);
        //如果是手动提交：  QueryRunner()无参；query()update()必须传入connection
        return account;
    }

    @Override
    public void updateAccount(Account account) throws SQLException{
        QueryRunner runner = new QueryRunner() ;
        Connection conn = JDBCUtil.getConnection() ;
        runner.update(conn,"update account set balance = ? where cardId = ?",new Object[]{account.getBalance(),account.getCardId()} );
    }
}
