package com.example.openeyes.databean

/**
 * @data on 2020/9/27 3:54 PM
 * @auther armStrong
 * @describe 首页
 */
data class HomeDataBean(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: Any,
    val total: Int
)

data class Item(
    val adIndex: Int,
    val `data`: Data,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class Data(
    val `content`: Content,
    val actionUrl: String,
    val ad: Boolean,
    val adTrack: Any,
    val author: Author,
    val autoPlay: Boolean,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val category: String,
    val collected: Boolean,
    val consumption: Consumption,
    val count: Int,
    val cover: Cover,
    val dataType: String,
    val date: Long,
    val description: String,
    val descriptionEditor: String,
    val descriptionPgc: Any,
    val detail: Detail,
    val duration: Int,
    val expert: Boolean,
    val favoriteAdTrack: Any,
    val follow: Any,
    val footer: Any,
    val haveReward: Boolean,
    val header: Header,
    val icon: String,
    val iconType: String,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val ifNewest: Boolean,
    val ifPgc: Boolean,
    val ifShowNotificationIcon: Boolean,
    val image: String,
    val itemList: List<ItemX>,
    val label: Any,
    val labelList: Any,
    val lastViewTime: Any,
    val library: String,
    val medalIcon: Boolean,
    val newestEndTime: Any,
    val playInfo: List<PlayInfo>,
    val playUrl: String,
    val played: Boolean,
    val playlists: Any,
    val promotion: Any,
    val provider: Provider,
    val reallyCollected: Boolean,
    val recallSource: Any,
    val recall_source: Any,
    val releaseTime: Long,
    val remark: Any,
    val resourceType: String,
    val rightText: String,
    val searchWeight: Int,
    val shade: Boolean,
    val shareAdTrack: Any,
    val slogan: Any,
    val src: Any,
    val subTitle: Any,
    val subtitles: List<Subtitle>,
    val titleList: List<String>,
    val switchStatus: Boolean,
    val tags: List<Tag>,
    val text: String,
    val thumbPlayUrl: Any,
    val title: String,
    val titlePgc: Any,
    val type: String,
    val uid: Int,
    val videoPosterBean: Any,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl
)

data class Content(
    val adIndex: Int,
    val `data`: DataX,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class Author(
    val adTrack: Any,
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val link: String,
    val name: String,
    val recSort: Int,
    val shield: Shield,
    val videoNum: Int
)

data class Consumption(
    val collectionCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
)

data class Cover(
    val blurred: String,
    val detail: String,
    val feed: String,
    val homepage: String,
    val sharing: Any
)

data class Detail(
    val actionUrl: String,
    val adTrack: List<AdTrack>,
    val adaptiveImageUrls: String,
    val adaptiveUrls: String,
    val canSkip: Boolean,
    val categoryId: Int,
    val countdown: Boolean,
    val cycleCount: Int,
    val description: String,
    val displayCount: Int,
    val displayTimeDuration: Int,
    val icon: String,
    val id: Int,
    val ifLinkage: Boolean,
    val imageUrl: String,
    val iosActionUrl: String,
    val linkageAdId: Int,
    val loadingMode: Int,
    val openSound: Boolean,
    val position: Int,
    val showActionButton: Boolean,
    val showImage: Boolean,
    val showImageTime: Int,
    val timeBeforeSkip: Int,
    val title: String,
    val url: String,
    val videoAdType: String,
    val videoType: String
)

data class Header(
    val actionUrl: String,
    val cover: Any,
    val description: String,
    val font: Any,
    val icon: String,
    val iconType: String,
    val id: Int,
    val label: Any,
    val labelList: Any,
    val rightText: String,
    val showHateVideo: Boolean,
    val subTitle: Any,
    val subTitleFont: Any,
    val textAlign: String,
    val time: Long,
    val title: String
)

data class ItemX(
    val adIndex: Int,
    val `data`: DataX,
    val id: Int,
    val tag: Any,
    val type: String
)

data class PlayInfo(
    val height: Int,
    val name: String,
    val type: String,
    val url: String,
    val urlList: List<Url>,
    val width: Int
)

data class Provider(
    val alias: String,
    val icon: String,
    val name: String
)

data class Subtitle(
    val type: String,
    val url: String
)

data class Tag(
    val actionUrl: String,
    val adTrack: Any,
    val bgPicture: String,
    val childTagIdList: Any,
    val childTagList: Any,
    val communityIndex: Int,
    val desc: String,
    val haveReward: Boolean,
    val headerImage: String,
    val id: Int,
    val ifNewest: Boolean,
    val name: String,
    val newestEndTime: Any,
    val tagRecType: String
)

data class WebUrl(
    val forWeibo: String,
    val raw: String
)

data class Follow(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)

data class Shield(
    val itemId: Int,
    val itemType: String,
    val shielded: Boolean
)

data class AdTrack(
    val clickUrl: String,
    val id: Int,
    val monitorPositions: String,
    val needExtraParams: List<String>,
    val organization: String,
    val playUrl: String,
    val viewUrl: String
)

data class DataX(
    val ad: Boolean,
    val adTrack: List<Any>,
    val author: Author,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val category: String,
    val collected: Boolean,
    val consumption: Consumption,
    val cover: Cover,
    val dataType: String,
    val date: Long,
    val description: String,
    val descriptionEditor: String,
    val descriptionPgc: Any,
    val duration: Int,
    val favoriteAdTrack: Any,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val label: Any,
    val labelList: List<Any>,
    val lastViewTime: Any,
    val library: String,
    val playInfo: List<PlayInfo>,
    val playUrl: String,
    val played: Boolean,
    val playlists: Any,
    val promotion: Any,
    val provider: Provider,
    val reallyCollected: Boolean,
    val recallSource: Any,
    val recall_source: Any,
    val releaseTime: Long,
    val remark: Any,
    val resourceType: String,
    val searchWeight: Int,
    val shareAdTrack: Any,
    val slogan: Any,
    val src: Any,
    val subtitles: List<Any>,
    val tags: List<Tag>,
    val thumbPlayUrl: Any,
    val title: String,
    val titlePgc: Any,
    val type: String,
    val titleList: List<String>,
    val videoPosterBean: Any,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl,
    val image: String
)

data class AdTrackX(
    val clickUrl: String,
    val id: Int,
    val monitorPositions: String,
    val needExtraParams: List<String>,
    val organization: String,
    val playUrl: String,
    val viewUrl: String
)

data class HeaderX(
    val actionUrl: Any,
    val cover: Any,
    val description: Any,
    val font: Any,
    val icon: Any,
    val id: Int,
    val label: Any,
    val labelList: Any,
    val rightText: Any,
    val subTitle: Any,
    val subTitleFont: Any,
    val textAlign: String,
    val title: Any
)

data class Label(
    val card: String,
    val detail: Any,
    val text: String
)

data class LabelX(
    val actionUrl: Any,
    val text: String
)

data class Url(
    val name: String,
    val size: Int,
    val url: String
)