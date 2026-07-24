package com.lifelink.app.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.lifelink.app.entities.Donor;
import com.lifelink.app.models.BloodGroupStat;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DonorDao_Impl implements DonorDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Donor> __insertionAdapterOfDonor;

  private final EntityDeletionOrUpdateAdapter<Donor> __deletionAdapterOfDonor;

  private final EntityDeletionOrUpdateAdapter<Donor> __updateAdapterOfDonor;

  public DonorDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDonor = new EntityInsertionAdapter<Donor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `donors` (`id`,`name`,`age`,`gender`,`bloodGroup`,`city`,`phone`,`lastDonationDate`,`available`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Donor entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getAge());
        if (entity.getGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getGender());
        }
        if (entity.getBloodGroup() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getBloodGroup());
        }
        if (entity.getCity() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCity());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPhone());
        }
        if (entity.getLastDonationDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getLastDonationDate());
        }
        final int _tmp = entity.getAvailable() ? 1 : 0;
        statement.bindLong(9, _tmp);
      }
    };
    this.__deletionAdapterOfDonor = new EntityDeletionOrUpdateAdapter<Donor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `donors` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Donor entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfDonor = new EntityDeletionOrUpdateAdapter<Donor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `donors` SET `id` = ?,`name` = ?,`age` = ?,`gender` = ?,`bloodGroup` = ?,`city` = ?,`phone` = ?,`lastDonationDate` = ?,`available` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Donor entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getAge());
        if (entity.getGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getGender());
        }
        if (entity.getBloodGroup() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getBloodGroup());
        }
        if (entity.getCity() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCity());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPhone());
        }
        if (entity.getLastDonationDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getLastDonationDate());
        }
        final int _tmp = entity.getAvailable() ? 1 : 0;
        statement.bindLong(9, _tmp);
        statement.bindLong(10, entity.getId());
      }
    };
  }

  @Override
  public Object insertDonor(final Donor donor, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfDonor.insertAndReturnId(donor);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteDonor(final Donor donor, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDonor.handle(donor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateDonor(final Donor donor, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfDonor.handle(donor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Donor>> getAllDonors() {
    final String _sql = "SELECT * FROM donors ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"donors"}, false, new Callable<List<Donor>>() {
      @Override
      @Nullable
      public List<Donor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBloodGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodGroup");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfLastDonationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastDonationDate");
          final int _cursorIndexOfAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "available");
          final List<Donor> _result = new ArrayList<Donor>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Donor _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpBloodGroup;
            if (_cursor.isNull(_cursorIndexOfBloodGroup)) {
              _tmpBloodGroup = null;
            } else {
              _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpLastDonationDate;
            if (_cursor.isNull(_cursorIndexOfLastDonationDate)) {
              _tmpLastDonationDate = null;
            } else {
              _tmpLastDonationDate = _cursor.getString(_cursorIndexOfLastDonationDate);
            }
            final boolean _tmpAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAvailable);
            _tmpAvailable = _tmp != 0;
            _item = new Donor(_tmpId,_tmpName,_tmpAge,_tmpGender,_tmpBloodGroup,_tmpCity,_tmpPhone,_tmpLastDonationDate,_tmpAvailable);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Donor> getDonorById(final int id) {
    final String _sql = "SELECT * FROM donors WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[] {"donors"}, false, new Callable<Donor>() {
      @Override
      @Nullable
      public Donor call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBloodGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodGroup");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfLastDonationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastDonationDate");
          final int _cursorIndexOfAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "available");
          final Donor _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpBloodGroup;
            if (_cursor.isNull(_cursorIndexOfBloodGroup)) {
              _tmpBloodGroup = null;
            } else {
              _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpLastDonationDate;
            if (_cursor.isNull(_cursorIndexOfLastDonationDate)) {
              _tmpLastDonationDate = null;
            } else {
              _tmpLastDonationDate = _cursor.getString(_cursorIndexOfLastDonationDate);
            }
            final boolean _tmpAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAvailable);
            _tmpAvailable = _tmp != 0;
            _result = new Donor(_tmpId,_tmpName,_tmpAge,_tmpGender,_tmpBloodGroup,_tmpCity,_tmpPhone,_tmpLastDonationDate,_tmpAvailable);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getDonorByIdSync(final int id, final Continuation<? super Donor> $completion) {
    final String _sql = "SELECT * FROM donors WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Donor>() {
      @Override
      @Nullable
      public Donor call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBloodGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodGroup");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfLastDonationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastDonationDate");
          final int _cursorIndexOfAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "available");
          final Donor _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpBloodGroup;
            if (_cursor.isNull(_cursorIndexOfBloodGroup)) {
              _tmpBloodGroup = null;
            } else {
              _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpLastDonationDate;
            if (_cursor.isNull(_cursorIndexOfLastDonationDate)) {
              _tmpLastDonationDate = null;
            } else {
              _tmpLastDonationDate = _cursor.getString(_cursorIndexOfLastDonationDate);
            }
            final boolean _tmpAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAvailable);
            _tmpAvailable = _tmp != 0;
            _result = new Donor(_tmpId,_tmpName,_tmpAge,_tmpGender,_tmpBloodGroup,_tmpCity,_tmpPhone,_tmpLastDonationDate,_tmpAvailable);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<Integer> getTotalDonorCount() {
    final String _sql = "SELECT COUNT(*) FROM donors";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"donors"}, false, new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Donor>> searchDonors(final String bloodGroup, final String city,
      final String query) {
    final String _sql = "\n"
            + "        SELECT * FROM donors\n"
            + "        WHERE (? = '' OR bloodGroup = ?)\n"
            + "        AND (? = '' OR city LIKE '%' || ? || '%')\n"
            + "        AND (? = '' OR name LIKE '%' || ? || '%' OR phone LIKE '%' || ? || '%')\n"
            + "        ORDER BY name ASC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 7);
    int _argIndex = 1;
    if (bloodGroup == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, bloodGroup);
    }
    _argIndex = 2;
    if (bloodGroup == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, bloodGroup);
    }
    _argIndex = 3;
    if (city == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, city);
    }
    _argIndex = 4;
    if (city == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, city);
    }
    _argIndex = 5;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 6;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 7;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"donors"}, false, new Callable<List<Donor>>() {
      @Override
      @Nullable
      public List<Donor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBloodGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodGroup");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfLastDonationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastDonationDate");
          final int _cursorIndexOfAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "available");
          final List<Donor> _result = new ArrayList<Donor>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Donor _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpBloodGroup;
            if (_cursor.isNull(_cursorIndexOfBloodGroup)) {
              _tmpBloodGroup = null;
            } else {
              _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpLastDonationDate;
            if (_cursor.isNull(_cursorIndexOfLastDonationDate)) {
              _tmpLastDonationDate = null;
            } else {
              _tmpLastDonationDate = _cursor.getString(_cursorIndexOfLastDonationDate);
            }
            final boolean _tmpAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAvailable);
            _tmpAvailable = _tmp != 0;
            _item = new Donor(_tmpId,_tmpName,_tmpAge,_tmpGender,_tmpBloodGroup,_tmpCity,_tmpPhone,_tmpLastDonationDate,_tmpAvailable);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<BloodGroupStat>> getBloodGroupStats() {
    final String _sql = "SELECT bloodGroup, COUNT(*) as donorCount FROM donors GROUP BY bloodGroup";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"donors"}, false, new Callable<List<BloodGroupStat>>() {
      @Override
      @Nullable
      public List<BloodGroupStat> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBloodGroup = 0;
          final int _cursorIndexOfDonorCount = 1;
          final List<BloodGroupStat> _result = new ArrayList<BloodGroupStat>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BloodGroupStat _item;
            final String _tmpBloodGroup;
            if (_cursor.isNull(_cursorIndexOfBloodGroup)) {
              _tmpBloodGroup = null;
            } else {
              _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            }
            final int _tmpDonorCount;
            _tmpDonorCount = _cursor.getInt(_cursorIndexOfDonorCount);
            _item = new BloodGroupStat(_tmpBloodGroup,_tmpDonorCount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
