package com.example.test2.Service.PrimaryService.Impl;

import com.example.test2.Service.PrimaryService.ConsoleRedisService;
import com.example.test2.Util.Secondary.TimeFormat;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.locks.ReentrantLock;

@Service("ConsoleRedisService")
public class ConsoleRedisServiceImpl implements ConsoleRedisService {

    @Resource(name = "defaultRedisTemplate")
    private RedisTemplate redisTemplate;

    @Resource
    private TimeFormat timeFormat;


    ReentrantLock todayScanQRTotalLock = new ReentrantLock();


    @Override
    public boolean insertNewScanQRTotal() {
        try{
            todayScanQRTotalLock.tryLock();
            redisTemplate.opsForValue().set(getKeyNameOfTodayScanQRTotal(), 0);
            return true;
        }catch (Exception e){
            return false;
        }finally {
            if (todayScanQRTotalLock.isHeldByCurrentThread()) {
                todayScanQRTotalLock.unlock();
            }
        }

    }

    @Override
    public boolean isExistTodayScanQRTotal() {
        return redisTemplate.opsForValue().get(getKeyNameOfTodayScanQRTotal()) != null;
    }


    @Override
    public boolean incrementTodayScanQRTotal() {

        try {
            todayScanQRTotalLock.lock();
            if (!isExistTodayScanQRTotal()) {
                return false;
            }
            Object o = redisTemplate.opsForValue().get(getKeyNameOfTodayScanQRTotal());
            redisTemplate.opsForValue().increment(getKeyNameOfTodayScanQRTotal());
            Long aLong = convertToLong(o);
            if (aLong==null)return false;
            return true;
        }finally {
            if (todayScanQRTotalLock.isHeldByCurrentThread()) {
                todayScanQRTotalLock.unlock();
            }
        }
    }

    @Override
    public Long getTodayScanTotal() {
        Object o = redisTemplate.opsForValue().get(getKeyNameOfTodayScanQRTotal());
        return convertToLong(o);
    }

    public String getKeyNameOfTodayScanQRTotal() {
        return timeFormat.getTodayDateFormat() + "_scanQRTotal";
    }


    //====================================================
    ReentrantLock usersTotalLock = new ReentrantLock();
    String userTotalKey = "userTotal";
    @Override
    public boolean insertUsersTotal(Long total) {

        try {

            usersTotalLock.lock();
            redisTemplate.opsForValue().set(userTotalKey, total);
            usersTotalLock.unlock();
            return true;

        } catch (Exception e) {
            return false;
        } finally {
            if (usersTotalLock.isHeldByCurrentThread()) {
                usersTotalLock.unlock();
            }
        }

    }

    public boolean isExistUsersTotal() {
        return redisTemplate.opsForValue().get(userTotalKey) != null;
    }

    //====================================================


    ReentrantLock placeNormalLock = new ReentrantLock();
    String placeForNormalKey = "placeForNormalTotal";
    @Override
    public boolean setPlaceForNormalTotal(Long total) {
        try{
            placeNormalLock.unlock();
            redisTemplate.opsForValue().set(placeForNormalKey,total);
            Object placeForNormalTotal = redisTemplate.opsForValue().get(placeForNormalKey);
            Long l = convertToLong(placeForNormalTotal);

            if (l==null){
                return false;
            }

            return l.equals(total);

        }catch (Exception e){

            e.printStackTrace();
            return false;

        }finally {

            if (placeNormalLock.isHeldByCurrentThread()) {
                placeNormalLock.unlock();
            }

        }

    }

    @Override
    public boolean incrementPlaceForNormalTotal() {
        return incrementModel(placeForNormalKey,placeNormalLock);
    }

    @Override
    public boolean decrementPlaceForNormalTotal() {
        return decrementModel(placeForNormalKey,placeNormalLock);
    }

    @Override
    public Long getCurNormalPlaceTotal() {
        Object o = redisTemplate.opsForValue().get(placeNormalLock);
        return convertToLong(o);
    }

    //========================================================

    ReentrantLock riskPlaceLock  = new ReentrantLock();
    String riskPlaceKey = "riskPlaceTotal";
    @Override
    public boolean incrementRiskPlaceTotal() {
        return incrementModel(riskPlaceKey,riskPlaceLock);
    }

    @Override
    public boolean decrementRiskPlaceTotal() {
        return decrementModel(riskPlaceKey,riskPlaceLock);
    }

    @Override
    public Long getCurRiskPlaceTotal() {
        return convertToLong(redisTemplate.opsForValue().get(riskPlaceKey));
    }

    @Override
    public Long getCurCarPlaceTotal() {
        return null;
    }

    //========================================================

    ReentrantLock registerLock = new ReentrantLock();
    String regisKey = "regisTotal";
    @Override
    public Long getRegisterTotal() {
        Object o = redisTemplate.opsForValue().get(regisKey);
        return convertToLong(o);
    }

    @Override
    public boolean incrementRegisterTotal() {
        return incrementModel(regisKey,registerLock);
    }

    @Override
    public boolean decrementRegisterTotal() {
        return decrementModel(regisKey,registerLock);
    }


    //========================================================








    /**
     *
     * 将 redisTemples返回的Object进行Long规格化
     *
     * @param o
     * @return
     */
    private Long convertToLong(Object o) {
        if (o ==null){
            return null;
        }
        if (o instanceof Integer) {
            return Long.parseLong(String.valueOf(o));
        }
        if (o instanceof Long)
            return (Long) o;
        return null;
    }



    /**
     *
     * increment操作model
     * @param key
     * @param lock
     * @return
     */
    public boolean incrementModel(String key,ReentrantLock lock){

        try{

            lock.lock();
            Object o = redisTemplate.opsForValue().get(key);
            Long l = convertToLong(o);
            if (l==null)return false;
            Long increment = redisTemplate.opsForValue().increment(key);
            return l.equals(increment);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        } finally{
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


    /**
     * decrement操作Model
     * @param key
     * @param lock
     * @return
     */
    public boolean decrementModel(String key,ReentrantLock lock){

        try{

            lock.lock();
            Object o = redisTemplate.opsForValue().get(key);
            Long l = convertToLong(o);
            if (l==null)return false;
            Long increment = redisTemplate.opsForValue().decrement(key);
            return l.equals(increment);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        } finally{
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


}
