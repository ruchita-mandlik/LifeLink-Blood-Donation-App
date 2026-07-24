package com.lifelink.app.dao;

import android.database.Cursor;
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
import com.lifelink.app.entities.BloodRequest;
import java.lang.Class;
import java.lang.Exception;
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
public final class BloodRequestDao_Impl implements BloodRequestDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BloodRequest> __insertionAdapterOfBloodRequest;

  private final EntityDeletionOrUpdateAdapter<BloodRequest> __deletionAdapterOfBloodRequest;

  private final EntityDeletionOrUpdateAdapter<BloodRequest> __updateAdapterOfBloodRequest;

  public BloodRequestDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBloodRequest = new EntityInsertionAdapter<BloodRequest>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `blood_requests` (`id`,`patientName`,`bloodGroup`,`city`,`hospital`,`units`,`contactNumber`,`urgency`,`date`,`completed`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BloodRequest entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getPatientName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPatientName());
        }
        if (entity.getBloodGroup() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getBloodGroup());
        }
        if (entity.getCity() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCity());
        }
        if (entity.getHospital() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getHospital());
        }
        statement.bindLong(6, entity.getUnits());
        if (entity.getContactNumber() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getContactNumber());
        }
        if (entity.getUrgency() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getUrgency());
        }
        if (entity.getDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDate());
        }
        final int _tmp = entity.getCompleted() ? 1 : 0;
        statement.bindLong(10, _tmp);
      }
    };
    this.__deletionAdapterOfBloodRequest = new EntityDeletionOrUpdateAdapter<BloodRequest>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `blood_requests` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BloodRequest entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfBloodRequest = new EntityDeletionOrUpdateAdapter<BloodRequest>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `blood_requests` SET `id` = ?,`patientName` = ?,`bloodGroup` = ?,`city` = ?,`hospital` = ?,`units` = ?,`contactNumber` = ?,`urgency` = ?,`date` = ?,`completed` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BloodRequest entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getPatientName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPatientName());
        }
        if (entity.getBloodGroup() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getBloodGroup());
        }
        if (entity.getCity() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCity());
        }
        if (entity.getHospital() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getHospital());
        }
        statement.bindLong(6, entity.getUnits());
        if (entity.getContactNumber() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getContactNumber());
        }
        if (entity.getUrgency() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getUrgency());
        }
        if (entity.getDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDate());
        }
        final int _tmp = entity.getCompleted() ? 1 : 0;
        statement.bindLong(10, _tmp);
        statement.bindLong(11, entity.getId());
      }
    };
  }

  @Override
  public Object insertRequest(final BloodRequest request,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfBloodRequest.insertAndReturnId(request);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRequest(final BloodRequest request,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfBloodRequest.handle(request);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateRequest(final BloodRequest request,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfBloodRequest.handle(request);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<BloodRequest>> getAllRequests() {
    final String _sql = "SELECT * FROM blood_requests ORDER BY completed ASC, id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"blood_requests"}, false, new Callable<List<BloodRequest>>() {
      @Override
      @Nullable
      public List<BloodRequest> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPatientName = CursorUtil.getColumnIndexOrThrow(_cursor, "patientName");
          final int _cursorIndexOfBloodGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodGroup");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfHospital = CursorUtil.getColumnIndexOrThrow(_cursor, "hospital");
          final int _cursorIndexOfUnits = CursorUtil.getColumnIndexOrThrow(_cursor, "units");
          final int _cursorIndexOfContactNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "contactNumber");
          final int _cursorIndexOfUrgency = CursorUtil.getColumnIndexOrThrow(_cursor, "urgency");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final List<BloodRequest> _result = new ArrayList<BloodRequest>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BloodRequest _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpPatientName;
            if (_cursor.isNull(_cursorIndexOfPatientName)) {
              _tmpPatientName = null;
            } else {
              _tmpPatientName = _cursor.getString(_cursorIndexOfPatientName);
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
            final String _tmpHospital;
            if (_cursor.isNull(_cursorIndexOfHospital)) {
              _tmpHospital = null;
            } else {
              _tmpHospital = _cursor.getString(_cursorIndexOfHospital);
            }
            final int _tmpUnits;
            _tmpUnits = _cursor.getInt(_cursorIndexOfUnits);
            final String _tmpContactNumber;
            if (_cursor.isNull(_cursorIndexOfContactNumber)) {
              _tmpContactNumber = null;
            } else {
              _tmpContactNumber = _cursor.getString(_cursorIndexOfContactNumber);
            }
            final String _tmpUrgency;
            if (_cursor.isNull(_cursorIndexOfUrgency)) {
              _tmpUrgency = null;
            } else {
              _tmpUrgency = _cursor.getString(_cursorIndexOfUrgency);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            _item = new BloodRequest(_tmpId,_tmpPatientName,_tmpBloodGroup,_tmpCity,_tmpHospital,_tmpUnits,_tmpContactNumber,_tmpUrgency,_tmpDate,_tmpCompleted);
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
