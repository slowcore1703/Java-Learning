public class User {}


@BanRegestration(days = {Days.MONDAY, Days.TUESDAY})
class User1 extends User{}


@BanRegestration(days = Days.SATURDAY)
class User2 extends User{}


@BanRegestration(days = Days.FRIDAY)
class User3 extends User{}

@Deprecated
class User4 extends User{}


@Deprecated
class User5 extends User{}