package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcoManagementPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {


    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {
                for (int k = 0; k < item.getFfamilyList().get(i).getFComponentList().get(j).getFcoManagementList().size(); k++) {
                    ps.setString(1, String.valueOf(k));
                    ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getId().concat(String.valueOf(k)));
                    ps.setString(3, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoManagementList().get(k).getEqual());
                    ps.setString(4, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoManagementList().get(k).getValue());
                    ps.setString(5, item.getFfamilyList().get(i).getFComponentList().get(j).getId());
                    ps.setString(6, item.getFfamilyList().get(i).getFComponentList().get(j).getId().concat(String.valueOf(k)));
                    ps.addBatch();
                }
            }

        }

    }
}
