package com.github.gfx.android.orma.example.orma;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.github.gfx.android.orma.AssociationDef;
import com.github.gfx.android.orma.ColumnDef;
import com.github.gfx.android.orma.OrmaConnection;
import com.github.gfx.android.orma.Schema;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.example.tool.TypeAdapters;
import com.github.gfx.android.orma.internal.Aliases;
import com.github.gfx.android.orma.internal.Schemas;
import java.util.Arrays;
import java.util.List;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZonedDateTime;

public class Item2_Schema implements Schema<Item2> {
  public static final Item2_Schema INSTANCE = Schemas.register(new Item2_Schema());

  @Nullable
  private final String $alias;

  public final AssociationDef<Item2, Category, Category_Schema> category1;

  public final AssociationDef<Item2, Category, Category_Schema> category2;

  public final ColumnDef<Item2, ZonedDateTime> zonedTimestamp;

  public final ColumnDef<Item2, LocalDateTime> localDateTime;

  public final ColumnDef<Item2, String> name;

  private final String[] $defaultResultColumns;

  public Item2_Schema() {
    this(new Aliases().createPath("Item2"));
  }

  public Item2_Schema(@Nullable Aliases.ColumnPath current) {
    $alias = current != null ? current.getAlias() : null;
    this.name = new ColumnDef<Item2, String>(this, "name", String.class, "TEXT", ColumnDef.PRIMARY_KEY) {
      @Override
      @NonNull
      public String get(@NonNull Item2 model) {
        return model.name;
      }

      @NonNull
      @Override
      public String getSerialized(@NonNull Item2 model) {
        return model.name;
      }

      @NonNull
      @Override
      public String getFromCursor(@NonNull OrmaConnection conn, @NonNull Cursor cursor, int index) {
        return cursor.getString(index);
      }
    };
    this.category1 = new AssociationDef<Item2, Category, Category_Schema>(this, "category1", Category.class, "INTEGER", ColumnDef.INDEXED, new Category_Schema(current != null ? current.add("category1", "Category") : null)) {
      @Override
      @NonNull
      public Category get(@NonNull Item2 model) {
        return model.category1;
      }

      @NonNull
      @Override
      public Long getSerialized(@NonNull Item2 model) {
        return model.category1.id;
      }

      @NonNull
      @Override
      public Category getFromCursor(@NonNull OrmaConnection conn, @NonNull Cursor cursor,
          int index) {
        return Category_Schema.INSTANCE.newModelFromCursor(conn, cursor, index + 1) /* consumes items: 2 */;
      }
    };
    this.category2 = new AssociationDef<Item2, Category, Category_Schema>(this, "category2", Category.class, "INTEGER", ColumnDef.NULLABLE | ColumnDef.INDEXED, new Category_Schema(current != null ? current.add("category2", "Category") : null)) {
      @Override
      @Nullable
      public Category get(@NonNull Item2 model) {
        return model.category2;
      }

      @Nullable
      @Override
      public Long getSerialized(@NonNull Item2 model) {
        return model.category2.id;
      }

      @Nullable
      @Override
      public Category getFromCursor(@NonNull OrmaConnection conn, @NonNull Cursor cursor,
          int index) {
        return cursor.isNull(index + 2) ? null : Category_Schema.INSTANCE.newModelFromCursor(conn, cursor, index + 1) /* consumes items: 2 */;
      }
    };
    this.zonedTimestamp = new ColumnDef<Item2, ZonedDateTime>(this, "zonedTimestamp", ZonedDateTime.class, "TEXT", 0) {
      @Override
      @NonNull
      public ZonedDateTime get(@NonNull Item2 model) {
        return model.zonedTimestamp;
      }

      @NonNull
      @Override
      public String getSerialized(@NonNull Item2 model) {
        return TypeAdapters.serializeZonedDateTime(model.zonedTimestamp);
      }

      @NonNull
      @Override
      public ZonedDateTime getFromCursor(@NonNull OrmaConnection conn, @NonNull Cursor cursor,
          int index) {
        return TypeAdapters.deserializeZonedDateTime(cursor.getString(index));
      }
    };
    this.localDateTime = new ColumnDef<Item2, LocalDateTime>(this, "localDateTime", LocalDateTime.class, "TEXT", 0) {
      @Override
      @NonNull
      public LocalDateTime get(@NonNull Item2 model) {
        return model.localDateTime;
      }

      @NonNull
      @Override
      public String getSerialized(@NonNull Item2 model) {
        return TypeAdapters.serializeLocalDateTime(model.localDateTime);
      }

      @NonNull
      @Override
      public LocalDateTime getFromCursor(@NonNull OrmaConnection conn, @NonNull Cursor cursor,
          int index) {
        return TypeAdapters.deserializeLocalDateTime(cursor.getString(index));
      }
    };
    $defaultResultColumns = new String[]{
          category1.getQualifiedName(),
            category1.associationSchema.name.getQualifiedName(),
            category1.associationSchema.id.getQualifiedName()
          ,
          category2.getQualifiedName(),
            category2.associationSchema.name.getQualifiedName(),
            category2.associationSchema.id.getQualifiedName()
          ,
          zonedTimestamp.getQualifiedName(),
          localDateTime.getQualifiedName(),
          name.getQualifiedName()
        };
  }

  @NonNull
  @Override
  public Class<Item2> getModelClass() {
    return Item2.class;
  }

  @NonNull
  @Override
  public String getTableName() {
    return "Item2";
  }

  @NonNull
  @Override
  public String getEscapedTableName() {
    return "`Item2`";
  }

  @Nullable
  @Override
  public String getTableAlias() {
    return $alias;
  }

  @Nullable
  @Override
  public String getEscapedTableAlias() {
    return $alias != null ? '`' + $alias + '`' : null;
  }

  @NonNull
  @Override
  public String getSelectFromTableClause() {
    return "`Item2`"+ " AS " + getEscapedTableAlias()
        + " LEFT OUTER JOIN `Category` AS " + category1.associationSchema.getEscapedTableAlias() + " ON " + category1.getQualifiedName() + " = " + category1.associationSchema.id.getQualifiedName()

        + " LEFT OUTER JOIN `Category` AS " + category2.associationSchema.getEscapedTableAlias() + " ON " + category2.getQualifiedName() + " = " + category2.associationSchema.id.getQualifiedName()

        ;
  }

  @NonNull
  @Override
  public ColumnDef<Item2, String> getPrimaryKey() {
    return name;
  }

  @NonNull
  @Override
  public List<ColumnDef<Item2, ?>> getColumns() {
    return Arrays.<ColumnDef<Item2, ?>>asList(
          category1,
          category2,
          zonedTimestamp,
          localDateTime,
          name
        );
  }

  @NonNull
  @Override
  public String[] getDefaultResultColumns() {
    return $defaultResultColumns;
  }

  @NonNull
  @Override
  public String getCreateTableStatement() {
    return "CREATE TABLE `Item2` (`category1` INTEGER NOT NULL REFERENCES `Category`(`id`) ON UPDATE CASCADE ON DELETE CASCADE, `category2` INTEGER REFERENCES `Category`(`id`) ON UPDATE CASCADE ON DELETE CASCADE, `zonedTimestamp` TEXT NOT NULL, `localDateTime` TEXT NOT NULL, `name` TEXT PRIMARY KEY)";
  }

  @NonNull
  @Override
  public List<String> getCreateIndexStatements() {
    return Arrays.asList(
      "CREATE INDEX `index_category1_on_Item2` ON `Item2` (`category1`)",
      "CREATE INDEX `index_category2_on_Item2` ON `Item2` (`category2`)"
    );
  }

  @NonNull
  @Override
  public String getDropTableStatement() {
    return "DROP TABLE IF EXISTS `Item2`";
  }

  @NonNull
  @Override
  public String getInsertStatement(@OnConflict int onConflictAlgorithm, boolean withoutAutoId) {
    StringBuilder s = new StringBuilder();
    s.append("INSERT");
    switch (onConflictAlgorithm) {
      case OnConflict.NONE: /* nop */ break;
      case OnConflict.ABORT: s.append(" OR ABORT"); break;
      case OnConflict.FAIL: s.append(" OR FAIL"); break;
      case OnConflict.IGNORE: s.append(" OR IGNORE"); break;
      case OnConflict.REPLACE: s.append(" OR REPLACE"); break;
      case OnConflict.ROLLBACK: s.append(" OR ROLLBACK"); break;
      default: throw new IllegalArgumentException("Invalid OnConflict algorithm: " + onConflictAlgorithm);
    }
    s.append(" INTO `Item2` (`category1`,`category2`,`zonedTimestamp`,`localDateTime`,`name`) VALUES (?,?,?,?,?)");
    return s.toString();
  }

  /**
   * Convert models to {@code Object[]}. Provided for debugging
   */
  @NonNull
  @Override
  public Object[] convertToArgs(@NonNull OrmaConnection conn, @NonNull Item2 model,
      boolean withoutAutoId) {
    Object[] args = new Object[5];
    if (model.category1 != null) {
      args[0] = model.category1.id;
    }
    else {
      throw new IllegalArgumentException("Item2.category1" + " must not be null, or use @Nullable to declare it as NULL");
    }
    if (model.category2 != null) {
      args[1] = model.category2.id;
    }
    if (model.zonedTimestamp != null) {
      args[2] = TypeAdapters.serializeZonedDateTime(model.zonedTimestamp);
    }
    else {
      throw new IllegalArgumentException("Item2.zonedTimestamp" + " must not be null, or use @Nullable to declare it as NULL");
    }
    if (model.localDateTime != null) {
      args[3] = TypeAdapters.serializeLocalDateTime(model.localDateTime);
    }
    else {
      throw new IllegalArgumentException("Item2.localDateTime" + " must not be null, or use @Nullable to declare it as NULL");
    }
    if (model.name != null) {
      args[4] = model.name;
    }
    else {
      throw new IllegalArgumentException("Item2.name" + " must not be null, or use @Nullable to declare it as NULL");
    }
    return args;
  }

  @Override
  public void bindArgs(@NonNull OrmaConnection conn, @NonNull SQLiteStatement statement,
      @NonNull Item2 model, boolean withoutAutoId) {
    statement.bindLong(1, model.category1.id);
    if (model.category2 != null) {
      statement.bindLong(2, model.category2.id);
    }
    else {
      statement.bindNull(2);
    }
    statement.bindString(3, TypeAdapters.serializeZonedDateTime(model.zonedTimestamp));
    statement.bindString(4, TypeAdapters.serializeLocalDateTime(model.localDateTime));
    statement.bindString(5, model.name);
  }

  @NonNull
  @Override
  public Item2 newModelFromCursor(@NonNull OrmaConnection conn, @NonNull Cursor cursor,
      int offset) {
    Item2 model = new Item2();
    model.category1 = Category_Schema.INSTANCE.newModelFromCursor(conn, cursor, offset + 0 + 1) /* consumes items: 2 */;
    model.category2 = cursor.isNull(offset + 3 + 2) ? null : Category_Schema.INSTANCE.newModelFromCursor(conn, cursor, offset + 3 + 1) /* consumes items: 2 */;
    model.zonedTimestamp = TypeAdapters.deserializeZonedDateTime(cursor.getString(offset + 6));
    model.localDateTime = TypeAdapters.deserializeLocalDateTime(cursor.getString(offset + 7));
    model.name = cursor.getString(offset + 8);
    return model;
  }
}
