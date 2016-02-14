/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.dao;
import mlv.medidev.delire.models.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import mlv.medidev.delire.facades.StaffFacade;

/**
 *
 * @author khalil
 */
public class StaffDAOImpl implements IStaffDAO{
    
    @EJB
    StaffFacade stfFacade;

    public StaffDAOImpl() {
        
    }
    
    @Override
    public boolean checkStaff(String username, String password,Integer role) {
        List<Staff> list = getStaffsByRole(role);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getStfUsername().equals(username) &&
                    list.get(i).getStfPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addStaff(Staff s) {
        stfFacade.create(s);
    }

    @Override
    public List<Staff> getStaffsByRole(Integer role_id) {
        List<Staff> list = new ArrayList<Staff>();
        Staff e =null;
                for(int i=0;i<stfFacade.count();i++){
                    e=stfFacade.find(role_id);
                    if(e!=null){
                        list.add(e);
                    }
                }
       return list;
    }

    
}
