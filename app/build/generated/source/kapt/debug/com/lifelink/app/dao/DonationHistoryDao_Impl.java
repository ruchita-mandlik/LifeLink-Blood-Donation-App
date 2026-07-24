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
import com.lifelink.app.entities.DonationHistory;
import com.lifelink.app.models.DonationHistoryUi;
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
public final class DonationHistoryDao_Impl implements DonationHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DonationHistory> __insertionAdapterOfDonationHistory;

  private final EntityDeletionOrUpdateAdapter<DonationHistory> __deletionAdapterOfDonationHistory;

  public DonationHistoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDonationHistory = new EntityInsertionAdapter<DonationHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `donation_history` (`id`,`donorId`,`donationDate`,`hospital`,`remarks`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DonationHistory entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getDonorId());
        if (entity.getDonationDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDonationDate());
        }
        if (entity.getHospital() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getHospital());
        }
        if (entity.getRemarks() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getRemarks());
        }
      }
    };
    this.__deletionAdapterOfDonationHistory = new EntityDeletionOrUpdateAdapter<DonationHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `donation_history` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DonationHistory entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertHistory(final DonationHistory history,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfDonationHistory.insertAndReturnId(history);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteHistory(final DonationHistory history,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDonationHistory.handle(history);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<DonationHistory>> getHistoryForDonor(final int donorId) {
    final String _sql = "SELECT * FROM donation_history WHERE donorId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, donorId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"donation_history"}, false, new Callable<List<DonationHistory>>() {
      @Override
      @Nullable
      public List<DonationHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDonorId = CursorUtil.getColumnIndexOrThrow(_cursor, "donorId");
          final int _cursorIndexOfDonationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "donationDate");
          final int _cursorIndexOfHospital = CursorUtil.getColumnIndexOrThrow(_cursor, "hospital");
          final int _cursorIndexOfRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "remarks");
          final List<DonationHistory> _result = new ArrayList<DonationHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DonationHistory _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpDonorId;
            _tmpDonorId = _cursor.getInt(_cursorIndexOfDonorId);
            final String _tmpDonationDate;
            if (_cursor.isNull(_cursorIndexOfDonationDate)) {
              _tmpDonationDate = null;
            } else {
              _tmpDonationDate = _cursor.getString(_cursorIndexOfDonationDate);
            }
            final String _tmpHospital;
            if (_cursor.isNull(_cursorIndexOfHospital)) {
              _tmpHospital = null;
            } else {
              _tmpHospital = _cursor.getString(_cursorIndexOfHospital);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _item = new DonationHistory(_tmpId,_tmpDonorId,_tmpDonationDate,_tmpHospital,_tmpRemarks);
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
  public LiveData<List<DonationHistoryUi>> getAllHistoryWithDonor() {
    final String _sql = "\n"
            + "        SELECT dh.id as historyId, dh.donorId as donorId, d.name as donorName,\n"
            + "               d.bloodGroup as bloodGroup, dh.donationDate as donationDate,\n"
            + "               dh.hospital as hospital, dh.remarks as remarks\n"
            + "        FROM donation_history dh\n"
            + "        INNER JOIN donors d ON dh.donorId = d.id\n"
            + "        ORDER BY dh.id DESC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"donation_history",
        "donors"}, false, new Callable<List<DonationHistoryUi>>() {
      @Override
      @Nullable
      public List<DonationHistoryUi> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHistoryId = 0;
          final int _cursorIndexOfDonorId = 1;
          final int _cursorIndexOfDonorName = 2;
          final int _cursorIndexOfBloodGroup = 3;
          final int _cursorIndexOfDonationDate = 4;
          final int _cursorIndexOfHospital = 5;
          final int _cursorIndexOfRemarks = 6;
          final List<DonationHistoryUi> _result = new ArrayList<DonationHistoryUi>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DonationHistoryUi _item;
            final int _tmpHistoryId;
            _tmpHistoryId = _cursor.getInt(_cursorIndexOfHistoryId);
            final int _tmpDonorId;
            _tmpDonorId = _cursor.getInt(_cursorIndexOfDonorId);
            final String _tmpDonorName;
            if (_cursor.isNull(_cursorIndexOfDonorName)) {
              _tmpDonorName = null;
            } else {
              _tmpDonorName = _cursor.getString(_cursorIndexOfDonorName);
            }
            final String _tmpBloodGroup;
            if (_cursor.isNull(_cursorIndexOfBloodGroup)) {
              _tmpBloodGroup = null;
            } else {
              _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            }
            final String _tmpDonationDate;
            if (_cursor.isNull(_cursorIndexOfDonationDate)) {
              _tmpDonationDate = null;
            } else {
              _tmpDonationDate = _cursor.getString(_cursorIndexOfDonationDate);
            }
            final String _tmpHospital;
            if (_cursor.isNull(_cursorIndexOfHospital)) {
              _tmpHospital = null;
            } else {
              _tmpHospital = _cursor.getString(_cursorIndexOfHospital);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _item = new DonationHistoryUi(_tmpHistoryId,_tmpDonorId,_tmpDonorName,_tmpBloodGroup,_tmpDonationDate,_tmpHospital,_tmpRemarks);
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
  public LiveData<List<DonationHistoryUi>> getRecentHistoryWithDonor(final int limit) {
    final String _sql = "\n"
            + "        SELECT dh.id as historyId, dh.donorId as donorId, d.name as donorName,\n"
            + "               d.bloodGroup as bloodGroup, dh.donationDate as donationDate,\n"
            + "               dh.hospital as hospital, dh.remarks as remarks\n"
            + "        FROM donation_history dh\n"
            + "        INNER JOIN donors d ON dh.donorId = d.id\n"
            + "        ORDER BY dh.id DESC LIMIT ?\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    return __db.getInvalidationTracker().createLiveData(new String[] {"donation_history",
        "donors"}, false, new Callable<List<DonationHistoryUi>>() {
      @Override
      @Nullable
      public List<DonationHistoryUi> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHistoryId = 0;
          final int _cursorIndexOfDonorId = 1;
          final int _cursorIndexOfDonorName = 2;
          final int _cursorIndexOfBloodGroup = 3;
          final int _cursorIndexOfDonationDate = 4;
          final int _cursorIndexOfHospital = 5;
          final int _cursorIndexOfRemarks = 6;
          final List<DonationHistoryUi> _result = new ArrayList<DonationHistoryUi>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DonationHistoryUi _item;
            final int _tmpHistoryId;
            _tmpHistoryId = _cursor.getInt(_cursorIndexOfHistoryId);
            final int _tmpDonorId;
            _tmpDonorId = _cursor.getInt(_cursorIndexOfDonorId);
            final String _tmpDonorName;
            if (_cursor.isNull(_cursorIndexOfDonorName)) {
              _tmpDonorName = null;
            } else {
              _tmpDonorName = _cursor.getString(_cursorIndexOfDonorName);
            }
            final String _tmpBloodGroup;
            if (_cursor.isNull(_cursorIndexOfBloodGroup)) {
              _tmpBloodGroup = null;
            } else {
              _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            }
            final String _tmpDonationDate;
            if (_cursor.isNull(_cursorIndexOfDonationDate)) {
              _tmpDonationDate = null;
            } else {
              _tmpDonationDate = _cursor.getString(_cursorIndexOfDonationDate);
            }
            final String _tmpHospital;
            if (_cursor.isNull(_cursorIndexOfHospital)) {
              _tmpHospital = null;
            } else {
              _tmpHospital = _cursor.getString(_cursorIndexOfHospital);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _item = new DonationHistoryUi(_tmpHistoryId,_tmpDonorId,_tmpDonorName,_tmpBloodGroup,_tmpDonationDate,_tmpHospital,_tmpRemarks);
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
