package app.models.query;

import app.HttpInterface;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PLong;
import io.ebean.typequery.PString;
import java.util.Collection;
import org.jspecify.annotations.Nullable;

/**
 * Query bean for ClubEntity.
 * <p>
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@SuppressWarnings("unused")
@io.ebean.typequery.Generated("io.ebean.querybean.generator")
@io.ebean.typequery.TypeQueryBean("v1")
public final class QClubEntity extends io.ebean.typequery.QueryBean<app.models.ClubEntity,QClubEntity> {

  private static final QClubEntity _alias = new QClubEntity(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QClubEntity alias() {
    return _alias;
  }

  public PLong<QClubEntity> id;
  public PString<QClubEntity> name;
  public PInteger<QClubEntity> memberCount;


  /**
   * Return a query bean used to build a FetchGroup.
   * <p>
   * FetchGroups are immutable and threadsafe and can be used by many
   * concurrent queries. We typically stored FetchGroup as a static final field.
   * <p>
   * Example creating and using a FetchGroup.
   * <pre>{@code
   * 
   * static final FetchGroup<Customer> fetchGroup = 
   *   QCustomer.forFetchGroup()
   *     .shippingAddress.fetch()
   *     .contacts.fetch()
   *     .buildFetchGroup();
   * 
   * List<Customer> customers = new QCustomer()
   *   .select(fetchGroup)
   *   .findList();
   * 
   * }</pre>
   */
  public static QClubEntity forFetchGroup() {
    return new QClubEntity(io.ebean.FetchGroup.queryFor(app.models.ClubEntity.class));
  }

  /** Construct using the default Database */
  public QClubEntity() {
    super(app.models.ClubEntity.class);
  }


  /** Construct with a given Database */
  public QClubEntity(io.ebean.Database database) {
    super(app.models.ClubEntity.class, database);
  }


  /** Private constructor for Alias */
  private QClubEntity(boolean dummy) {
    super(dummy);
  }

  /** Private constructor for FetchGroup building */
  private QClubEntity(io.ebean.Query<app.models.ClubEntity> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /** Private constructor for filterMany */
  private QClubEntity(io.ebean.ExpressionList<app.models.ClubEntity> filter) {
    super(filter);
  }

  /** Return a copy of the query bean. */
  @Override
  public QClubEntity copy() {
    return new QClubEntity(query().copy());
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  @io.ebean.typequery.Generated("io.ebean.querybean.generator")
  public static final class Alias {
    public static PLong<QClubEntity> id = _alias.id;
    public static PString<QClubEntity> name = _alias.name;
    public static PInteger<QClubEntity> memberCount = _alias.memberCount;
  }

  /** Association query bean */
  @io.ebean.typequery.Generated("io.ebean.querybean.generator")
  @io.ebean.typequery.TypeQueryBean("v1")
  public static abstract class Assoc<R> extends io.ebean.typequery.TQAssocBean<app.models.ClubEntity,R,QClubEntity> {

    public PLong<R> id;
    public PString<R> name;
    public PInteger<R> memberCount;

    public Assoc(String name, R root) { super(name, root); }
    public Assoc(String name, R root, String prefix) { super(name, root, prefix); }
  /**
   * Is equal to by ID property.
   */
  public final R eq(HttpInterface value) {
    expr().eq(_name, value);
    return _root;
  }

  /**
   * Is equal to by ID property if the value is not null, if null no expression is added.
   */
  public final R eqIfPresent(@Nullable HttpInterface value) {
    expr().eqIfPresent(_name, value);
    return _root;
  }

  /**
   * IN the given values.
   */
  public final R in(HttpInterface... values) {
    expr().in(_name, (Object[])values);
    return _root;
  }

  /**
   * IN the given interface values.
   */
  public final R inBy(Collection<? extends HttpInterface> values) {
    expr().in(_name, values);
    return _root;
  }

  /**
   * IN the given interface values if the collection is not empty. No expression is added if the collection is empty..
   */
  public final R inOrEmptyBy(@Nullable Collection<? extends HttpInterface> values) {
    expr().inOrEmpty(_name, values);
    return _root;
  }

  }

  /** Associated ToOne query bean */
  @io.ebean.typequery.Generated("io.ebean.querybean.generator")
  @io.ebean.typequery.TypeQueryBean("v1")
  public static final class AssocOne<R> extends Assoc<R> {
    public AssocOne(String name, R root) { super(name, root); }
    public AssocOne(String name, R root, String prefix) { super(name, root, prefix); }
  }

  /** Associated ToMany query bean */
  @io.ebean.typequery.Generated("io.ebean.querybean.generator")
  @io.ebean.typequery.TypeQueryBean("v1")
  public static final class AssocMany<R> extends Assoc<R> implements io.ebean.typequery.TQAssocMany<app.models.ClubEntity, R, QClubEntity>{
    public AssocMany(String name, R root) { super(name, root); }
    public AssocMany(String name, R root, String prefix) { super(name, root, prefix); }

    @Override
    public R filterMany(java.util.function.Consumer<QClubEntity> apply) {
      final io.ebean.ExpressionList<app.models.ClubEntity> list = _newExpressionList();
      apply.accept(new QClubEntity(list));
      return _filterMany(list);
    }

    @Override
    public R filterMany(io.ebean.ExpressionList<app.models.ClubEntity> filter) { return _filterMany(filter); }

    @Override
    public R filterManyRaw(String rawExpressions, Object... params) { return _filterManyRaw(rawExpressions, params); }

    @Override
    public R isEmpty() { return _isEmpty(); }

    @Override
    public R isNotEmpty() { return _isNotEmpty(); }
  }
}
