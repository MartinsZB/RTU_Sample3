package lv.zabarovski.m.rtu_sample3

import androidx.room.*

@Entity(tableName = "item_list")
data class ItemList (
    val name: String,
    val quantity: Int,
    val unit: String,
    @PrimaryKey(autoGenerate = true) var uid: Long = 0
)

@Dao
interface ItemListDao{
    @Insert
        fun insertAll(vararg items:ItemList): List<Long>
    @Query("SELECT * FROM item_list")
        fun getAll(): List<ItemList>
    @Query("SELECT * FROM item_list WHERE uid = :itemId")
        fun getItemById(itemId: Long): ItemList
    @Update
        fun update(item: ItemList)
    @Delete
        fun delete(item: ItemList)
}