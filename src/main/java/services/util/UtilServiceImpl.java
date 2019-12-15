package services.util;

import javax.ejb.Stateless;

@Stateless(name = UtilService.NAME)
public class UtilServiceImpl implements UtilService {

    @Override
    public Integer parseIntegerFromString(String capacity){
        Integer intCapacity = null;
        try {
            intCapacity = Integer.parseInt(capacity);
        }catch (NumberFormatException e){
            e.printStackTrace();
        } finally {
            return intCapacity;
        }
    }


    @Override
    public Boolean extractCheckBoxValue(String value){
        return value != null && value.equals("on");
    }
}
