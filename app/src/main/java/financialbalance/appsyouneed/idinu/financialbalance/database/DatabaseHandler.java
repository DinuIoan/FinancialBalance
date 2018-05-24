package financialbalance.appsyouneed.idinu.financialbalance.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import financialbalance.appsyouneed.idinu.financialbalance.model.IncomeOutcome;
import financialbalance.appsyouneed.idinu.financialbalance.model.MonthSavings;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FinancialBalance";
    private static final int DATABASE_VERSION = 1;

    /*INCOMES TABLE*/
    private static final String INCOMES_OUTCOMES_TABLE = "IncomeOutcome";

    private static final String ID = "id";
    private static final String TYPE = "type";
    private static final String DESCRIPTION = "description";
    private static final String VALUE = "value";
    private static final String TIMESTAMP = "timestamp";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String IS_MONTHLY = "isMonthly";
    private static final String IS_PRIVATE = "isPrivate";

    /*CALENDAR TABLE*/
    private static final String MONTH_SAVINGS_TABLE = "monthSavings";
    private static final String MONTH = "month";
    private static final String SAVINGS = "savings";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_INCOMES_OUTCOMES_TABLE = " create table " + INCOMES_OUTCOMES_TABLE +
                " ( "
                    + ID + " integer primary key autoincrement, "
                    + TYPE + " text, "
                    + DESCRIPTION + " text, "
                    + VALUE + " integer, "
                    + TIMESTAMP + " biginteger, "
                    + START_DATE + "biginteger, "
                    + END_DATE + "biginteger, "
                    + IS_MONTHLY + " integer, "
                    + IS_PRIVATE + "integer " +
                " ) ";
        String CREATE_MONTH_SAVINGS_TABLE = " create table " + MONTH_SAVINGS_TABLE +
                " ( "
                    + ID + " integer primary key autoincrement, "
                    + MONTH + " text, "
                    + SAVINGS + " integer " +
                " ) ";

        db.execSQL(CREATE_INCOMES_OUTCOMES_TABLE);
        db.execSQL(CREATE_MONTH_SAVINGS_TABLE);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + INCOMES_OUTCOMES_TABLE);
        db.execSQL("drop table if exists " + MONTH_SAVINGS_TABLE);
        onCreate(db);
    }

    public void addIncomeOutcome(IncomeOutcome incomeOutcome) {
        SQLiteDatabase database = getWritableDatabase();
        String ADD_INCOME_OUTCOME = " insert into " + INCOMES_OUTCOMES_TABLE +
                " values(null, '"
                    + incomeOutcome.getType() + "', '"
                    + incomeOutcome.getDescription() + "', '"
                    + incomeOutcome.getValue() + "', '"
                    + incomeOutcome.getTimestamp() + "', '"
                    + incomeOutcome.getStartDate() + "', '"
                    + incomeOutcome.getEndDate() + "', '"
                    + incomeOutcome.getIsMonthly() + "', '"
                    + incomeOutcome.getIsPrivate() + "')";
        database.execSQL(ADD_INCOME_OUTCOME);
        database.close();
    }

    public void addMonthSavings(MonthSavings monthSavings) {
        SQLiteDatabase database = getWritableDatabase();
        String ADD_MONTH_SAVINGS = " insert into " + MONTH_SAVINGS_TABLE +
                "values(null, '"
                    + monthSavings.getMonth() + "', '"
                    + monthSavings.getSavings() + "')";
        database.execSQL(ADD_MONTH_SAVINGS);
        database.close();
    }

    public void deleteIncomeOutcome(int id) {
        SQLiteDatabase database = getWritableDatabase();
        String DELETE_INCOME_OUTCOME = "delete from " + INCOMES_OUTCOMES_TABLE +
                " where " + ID + " = " + id;
        database.execSQL(DELETE_INCOME_OUTCOME);
        database.close();
    }

    public void deleteMonthSavings(int id) {
        SQLiteDatabase database = getWritableDatabase();
        String DELETE_MONTH_SAVINGS = "delete from " + MONTH_SAVINGS_TABLE +
                " where " + ID + " = " + id;
        database.execSQL(DELETE_MONTH_SAVINGS);
        database.close();
    }

    public void updateIncomesOutcomes(int idToUpdate, IncomeOutcome incomeOutcome) {
        SQLiteDatabase database = getWritableDatabase();
        String UPDATE_INCOME_OUTCOME = "update " + INCOMES_OUTCOMES_TABLE +
                " set "
                    + TYPE + " = '" + incomeOutcome.getType() + "' "
                    + DESCRIPTION + " = '" + incomeOutcome.getDescription() + "', "
                    + VALUE + " = '" + incomeOutcome.getValue() + "' "
                    + TIMESTAMP + " = '" + incomeOutcome.getTimestamp() + "', "
                    + START_DATE + " = '" + incomeOutcome.getStartDate() + "', "
                    + END_DATE + " = '" + incomeOutcome.getEndDate() + "', "
                    + IS_MONTHLY + " = '" + incomeOutcome.getIsMonthly() + "', "
                    + IS_PRIVATE + " = '" + incomeOutcome.getIsPrivate() + "' "
                + " where " + ID + " = " + idToUpdate;
        database.execSQL(UPDATE_INCOME_OUTCOME);
        database.close();
    }

    public void updateMonthSavings(int idToUpdate, MonthSavings monthSavings) {
        SQLiteDatabase database = getWritableDatabase();
        String UPDATE_MONTH_SAVINGS = "update " + MONTH_SAVINGS_TABLE +
                " set "
                    + MONTH + " = '" + monthSavings.getMonth() + "', "
                    + SAVINGS + " = '" + monthSavings.getSavings() + "' "
                + " where " + ID + " = " + idToUpdate;
        database.execSQL(UPDATE_MONTH_SAVINGS);
        database.close();
    }

    private IncomeOutcome getIncome(int id) {
        SQLiteDatabase database = getReadableDatabase();
        String SELECT_INCOME_BY_ID = "select * from " + INCOMES_OUTCOMES_TABLE +
                " where " + ID + " = " + id + " and " + TYPE + " = " + "income";
        Cursor cursor = database.rawQuery(SELECT_INCOME_BY_ID, null);
        IncomeOutcome income = new IncomeOutcome();

        while (cursor.moveToFirst()) {
            income.setId(cursor.getInt(0));
            income.setType(cursor.getString(1));
            income.setDescription(cursor.getString(2));
            income.setValue(cursor.getLong(3));
            income.setTimestamp(cursor.getLong(4));
            income.setStartDate(cursor.getLong(5));
            income.setEndDate(cursor.getLong(6));
            income.setIsMonthly(cursor.getInt(7));
            income.setIsPrivate(cursor.getInt(8));
        }
        cursor.close();
        database.close();
        return income;
    }

    private IncomeOutcome getOutcome(int id) {
        SQLiteDatabase database = getReadableDatabase();
        String SELECT_OUTCOME_BY_ID = "select * from " + INCOMES_OUTCOMES_TABLE +
                " where " + ID + " = " + id + " and " + TYPE + " = " + "outcome";
        Cursor cursor = database.rawQuery(SELECT_OUTCOME_BY_ID, null);
        IncomeOutcome outcome = new IncomeOutcome();

        while (cursor.moveToFirst()) {
            outcome.setId(cursor.getInt(0));
            outcome.setType(cursor.getString(1));
            outcome.setDescription(cursor.getString(2));
            outcome.setValue(cursor.getLong(3));
            outcome.setTimestamp(cursor.getLong(4));
            outcome.setStartDate(cursor.getLong(5));
            outcome.setEndDate(cursor.getLong(6));
            outcome.setIsMonthly(cursor.getInt(7));
            outcome.setIsPrivate(cursor.getInt(8));
        }
        cursor.close();
        database.close();
        return outcome;
    }

    public List<IncomeOutcome> getAllIncomesOrOutcomes(String type) {
        SQLiteDatabase database = getReadableDatabase();
        String SELECT_ALL_INCOMES_OR_OUTCOMES = "select * from " + INCOMES_OUTCOMES_TABLE +
                " where " + TYPE + " = '" + type + "'";
        Cursor cursor = database.rawQuery(SELECT_ALL_INCOMES_OR_OUTCOMES, null);
        List<IncomeOutcome> incomeOrOutcomes = new ArrayList<>();

        while (cursor.moveToNext()) {
            IncomeOutcome incomeOutcome = new IncomeOutcome();
            incomeOutcome.setId(cursor.getInt(0));
            incomeOutcome.setType(cursor.getString(1));
            incomeOutcome.setDescription(cursor.getString(2));
            incomeOutcome.setValue(cursor.getLong(3));
            incomeOutcome.setTimestamp(cursor.getLong(4));
            incomeOutcome.setStartDate(cursor.getLong(5));
            incomeOutcome.setEndDate(cursor.getLong(6));
            incomeOutcome.setIsMonthly(cursor.getInt(7));
            incomeOutcome.setIsPrivate(cursor.getInt(8));
            incomeOrOutcomes.add(incomeOutcome);
        }
        cursor.close();
        database.close();
        return incomeOrOutcomes;
    }

    public List<IncomeOutcome> getAllIncomesOutcomes() {
        SQLiteDatabase database = getReadableDatabase();
        String SELECT_ALL_INCOMES_OUTCOMES = "select * from " + INCOMES_OUTCOMES_TABLE;
        Cursor cursor = database.rawQuery(SELECT_ALL_INCOMES_OUTCOMES, null);
        List<IncomeOutcome> incomeOutcomesList = new ArrayList<>();

        while (cursor.moveToNext()) {
            IncomeOutcome incomeOutcome = new IncomeOutcome();
            incomeOutcome.setId(cursor.getInt(0));
            incomeOutcome.setType(cursor.getString(1));
            incomeOutcome.setDescription(cursor.getString(2));
            incomeOutcome.setValue(cursor.getLong(3));
            incomeOutcome.setTimestamp(cursor.getLong(4));
            incomeOutcome.setStartDate(cursor.getLong(5));
            incomeOutcome.setEndDate(cursor.getLong(6));
            incomeOutcome.setIsMonthly(cursor.getInt(7));
            incomeOutcome.setIsPrivate(cursor.getInt(8));
            incomeOutcomesList.add(incomeOutcome);
        }
        cursor.close();
        database.close();
        return incomeOutcomesList;
    }

}
