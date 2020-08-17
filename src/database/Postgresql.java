package database;

import database.Constants.Basic;
import database.Constants.PG;
/**
 *
 * @author Lucas Oliveira
 */
public class Postgresql extends BasicDatabase {
    public Postgresql() throws Exception {
        super(PG.BASE_URL, PG.HOST, PG.DB, PG.DRIVER, PG.USER, PG.PASS);
        if(!tryOpen())
            throw new Exception(Basic.EX_MSG);
    }
}
