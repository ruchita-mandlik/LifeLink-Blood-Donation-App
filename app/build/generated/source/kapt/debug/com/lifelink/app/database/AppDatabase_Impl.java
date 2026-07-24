package com.lifelink.app.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.lifelink.app.dao.BloodRequestDao;
import com.lifelink.app.dao.BloodRequestDao_Impl;
import com.lifelink.app.dao.DonationHistoryDao;
import com.lifelink.app.dao.DonationHistoryDao_Impl;
import com.lifelink.app.dao.DonorDao;
import com.lifelink.app.dao.DonorDao_Impl;
import com.lifelink.app.dao.UserDao;
import com.lifelink.app.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile DonorDao _donorDao;

  private volatile BloodRequestDao _bloodRequestDao;

  private volatile DonationHistoryDao _donationHistoryDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, `phone` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `donors` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `age` INTEGER NOT NULL, `gender` TEXT NOT NULL, `bloodGroup` TEXT NOT NULL, `city` TEXT NOT NULL, `phone` TEXT NOT NULL, `lastDonationDate` TEXT, `available` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `blood_requests` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `patientName` TEXT NOT NULL, `bloodGroup` TEXT NOT NULL, `city` TEXT NOT NULL, `hospital` TEXT NOT NULL, `units` INTEGER NOT NULL, `contactNumber` TEXT NOT NULL, `urgency` TEXT NOT NULL, `date` TEXT NOT NULL, `completed` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `donation_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `donorId` INTEGER NOT NULL, `donationDate` TEXT NOT NULL, `hospital` TEXT NOT NULL, `remarks` TEXT NOT NULL, FOREIGN KEY(`donorId`) REFERENCES `donors`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_donation_history_donorId` ON `donation_history` (`donorId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '89b1564ba5b781b976015deee0116a60')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `donors`");
        db.execSQL("DROP TABLE IF EXISTS `blood_requests`");
        db.execSQL("DROP TABLE IF EXISTS `donation_history`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(5);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.lifelink.app.entities.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsDonors = new HashMap<String, TableInfo.Column>(9);
        _columnsDonors.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonors.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonors.put("age", new TableInfo.Column("age", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonors.put("gender", new TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonors.put("bloodGroup", new TableInfo.Column("bloodGroup", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonors.put("city", new TableInfo.Column("city", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonors.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonors.put("lastDonationDate", new TableInfo.Column("lastDonationDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonors.put("available", new TableInfo.Column("available", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDonors = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDonors = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDonors = new TableInfo("donors", _columnsDonors, _foreignKeysDonors, _indicesDonors);
        final TableInfo _existingDonors = TableInfo.read(db, "donors");
        if (!_infoDonors.equals(_existingDonors)) {
          return new RoomOpenHelper.ValidationResult(false, "donors(com.lifelink.app.entities.Donor).\n"
                  + " Expected:\n" + _infoDonors + "\n"
                  + " Found:\n" + _existingDonors);
        }
        final HashMap<String, TableInfo.Column> _columnsBloodRequests = new HashMap<String, TableInfo.Column>(10);
        _columnsBloodRequests.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("patientName", new TableInfo.Column("patientName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("bloodGroup", new TableInfo.Column("bloodGroup", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("city", new TableInfo.Column("city", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("hospital", new TableInfo.Column("hospital", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("units", new TableInfo.Column("units", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("contactNumber", new TableInfo.Column("contactNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("urgency", new TableInfo.Column("urgency", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBloodRequests.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBloodRequests = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBloodRequests = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBloodRequests = new TableInfo("blood_requests", _columnsBloodRequests, _foreignKeysBloodRequests, _indicesBloodRequests);
        final TableInfo _existingBloodRequests = TableInfo.read(db, "blood_requests");
        if (!_infoBloodRequests.equals(_existingBloodRequests)) {
          return new RoomOpenHelper.ValidationResult(false, "blood_requests(com.lifelink.app.entities.BloodRequest).\n"
                  + " Expected:\n" + _infoBloodRequests + "\n"
                  + " Found:\n" + _existingBloodRequests);
        }
        final HashMap<String, TableInfo.Column> _columnsDonationHistory = new HashMap<String, TableInfo.Column>(5);
        _columnsDonationHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonationHistory.put("donorId", new TableInfo.Column("donorId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonationHistory.put("donationDate", new TableInfo.Column("donationDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonationHistory.put("hospital", new TableInfo.Column("hospital", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDonationHistory.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDonationHistory = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysDonationHistory.add(new TableInfo.ForeignKey("donors", "CASCADE", "NO ACTION", Arrays.asList("donorId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesDonationHistory = new HashSet<TableInfo.Index>(1);
        _indicesDonationHistory.add(new TableInfo.Index("index_donation_history_donorId", false, Arrays.asList("donorId"), Arrays.asList("ASC")));
        final TableInfo _infoDonationHistory = new TableInfo("donation_history", _columnsDonationHistory, _foreignKeysDonationHistory, _indicesDonationHistory);
        final TableInfo _existingDonationHistory = TableInfo.read(db, "donation_history");
        if (!_infoDonationHistory.equals(_existingDonationHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "donation_history(com.lifelink.app.entities.DonationHistory).\n"
                  + " Expected:\n" + _infoDonationHistory + "\n"
                  + " Found:\n" + _existingDonationHistory);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "89b1564ba5b781b976015deee0116a60", "7edff8f65cd4a766d899c3fb93d08e39");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","donors","blood_requests","donation_history");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `donors`");
      _db.execSQL("DELETE FROM `blood_requests`");
      _db.execSQL("DELETE FROM `donation_history`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DonorDao.class, DonorDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BloodRequestDao.class, BloodRequestDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DonationHistoryDao.class, DonationHistoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public DonorDao donorDao() {
    if (_donorDao != null) {
      return _donorDao;
    } else {
      synchronized(this) {
        if(_donorDao == null) {
          _donorDao = new DonorDao_Impl(this);
        }
        return _donorDao;
      }
    }
  }

  @Override
  public BloodRequestDao bloodRequestDao() {
    if (_bloodRequestDao != null) {
      return _bloodRequestDao;
    } else {
      synchronized(this) {
        if(_bloodRequestDao == null) {
          _bloodRequestDao = new BloodRequestDao_Impl(this);
        }
        return _bloodRequestDao;
      }
    }
  }

  @Override
  public DonationHistoryDao donationHistoryDao() {
    if (_donationHistoryDao != null) {
      return _donationHistoryDao;
    } else {
      synchronized(this) {
        if(_donationHistoryDao == null) {
          _donationHistoryDao = new DonationHistoryDao_Impl(this);
        }
        return _donationHistoryDao;
      }
    }
  }
}
