package data

data class Post(
    val id: Int, // Идентификатор записи
    val ownerId: Int, // Идентификатор владельца стены
    val fromId: Int, // Идентификатор автора записи
    val createdBy: Int?, // Идентификатор администратора, опубликовавшего запись
    val date: Int, // Время публикации в формате unixtime
    val text: String, // Текст записи
    val replyOwnerId: Int?, // Идентификатор владельца записи, на которую дан ответ
    val replyPostId: Int?, // Идентификатор записи, на которую дан ответ
    val friendsOnly: Boolean, // Запись только для друзей
    val comments: Comments, // Комментарии
    val likes: Likes, // Лайки
    val reposts: Reposts, // Репосты
    val views: Views?, // Просмотры
    val postType: String, // Тип записи
    val postSource: PostSource?, // Источник записи
    val geo: Geo?, // Геолокация
    val signerId: Int?, // Идентификатор подписавшего запись
    val copyHistory: List<Post>?, // История репостов
    val canPin: Boolean, // Можно ли закрепить запись
    val canDelete: Boolean, // Можно ли удалить запись
    val canEdit: Boolean, // Можно ли редактировать запись
    val isPinned: Boolean, // Запись закреплена
    val markedAsAds: Boolean, // Отмечена как реклама
    val isFavorite: Boolean, // В закладках у пользователя
    val donut: Donut?, // Информация VK Donut
    val postponedId: Int? // Идентификатор отложенной записи
)

// Класс для комментариев
data class Comments(
    val count: Int, // Количество комментариев
    val canPost: Boolean, // Можно ли комментировать
    val groupsCanPost: Boolean, // Могут ли группы комментировать
    val canClose: Boolean, // Можно ли закрыть комментарии
    val canOpen: Boolean // Можно ли открыть комментарии
)

// Класс для лайков
data class Likes(
    val count: Int, // Количество лайков
    val userLikes: Boolean, // Лайкнул ли текущий пользователь
    val canLike: Boolean, // Можно ли ставить лайк
    val canPublish: Boolean // Можно ли сделать репост
)

// Класс для репостов
data class Reposts(
    val count: Int, // Число пользователей, скопировавших запись
    val userReposted: Boolean // Наличие репоста от текущего пользователя
)

// Класс для просмотров
data class Views(
    val count: Int // Число просмотров записи
)

// Класс для геолокации
data class Geo(
    val type: String, // Тип места
    val coordinates: String, // Координаты места
    val place: Place // Описание места
)

// Класс для описания места
data class Place(
    val id: Int, // Идентификатор места
    val title: String, // Название места
    val latitude: Double, // Широта
    val longitude: Double, // Долгота
    val created: Int, // Время создания места в формате unixtime
    val icon: String, // Ссылка на иконку места
    val checkins: Int, // Число чекинов
    val updated: Int, // Время последнего обновления места в формате unixtime
    val type: Int, // Тип места
    val country: Int, // Идентификатор страны
    val city: Int, // Идентификатор города
    val address: String // Адрес
)

// Класс для информации VK Donut
data class Donut(
    val isDonut: Boolean, // Запись доступна только платным подписчикам VK Donut
    val paidDuration: Int, // Время доступности только для платных подписчиков
    val canPublishFreeCopy: Boolean, // Можно ли открыть запись для всех пользователей
    val editMode: String // Информация о возможных изменениях VK Donut в записи
)
// Класс для источника записи
data class PostSource(
    val type: String, // Тип источника
    val platform: String, // Платформа
    val data: String, // Дополнительные данные
    val url: String // Ссылка на источник
)