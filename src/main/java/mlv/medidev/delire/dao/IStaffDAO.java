/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.dao;

import java.util.List;
import mlv.medidev.delire.models.*;
/**
 *
 * @author khalil
 */
public interface IStaffDAO {
    
    public boolean checkStaff(String username,String password,Integer role);
    public List<Staff> getStaffsByRole(Integer role_id);
    public void addStaff(Staff s);
}
