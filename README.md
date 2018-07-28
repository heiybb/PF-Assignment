# PF-Assignment
Programming Fundamentals (045682) Assignment Backup

Main difficulty in assignment 2

```java
/** query all the comments include the childNode*/
private void queryCmt(Comment acmt, int depth) {
    List<Comment> sonList = acmt.childNode;
    String space = generateSpace(depth);

    if (sonList == null || sonList.isEmpty()) {
        return;
    }

    for (int i = 0; i < sonList.size(); i++) {
        System.out.println(space + sonList.get(i).getUserNameID() + ":" + sonList.get(i).getUsrComment());
        if (i == 0) {
            depth = depth + 1;
        }
        queryCmt(sonList.get(i), depth);
    }
}
```