package cn.yejh.transaction.service;


//转账
public interface AccountService {
    void transfer(int fromCardId, int toCardId, int money);
}
