package com.example.openeyes.databean

/**
 * @data on 2020/10/29 11:30 AM
 * @auther
 * @describe
 */
data class HomeTuijianDataBean(
    val code: String,
    val message: Message1,
    val result: Result
)

data class Message1(
    val action: String,
    val content: String
)

data class Result(
    val card_list: List<Card>,
    val float_entrance: List<Any>,
    val page_info: PageInfo
)

data class Card(
    val card_data: CardData,
    val card_id: Int,
    val interaction: Interaction,
    val style: StyleXXXX,
    val tracking_data: TrackingDataXXXX,
    val type: String
)

data class PageInfo(
    val title: String
)

data class CardData(
    val body: Body,
    val footer: Footer,
    val header: Header1
)

data class Interaction(
    val scroll: String
)

data class StyleXXXX(
    val padding: PaddingX
)

class TrackingDataXXXX(
)

data class Body(
    val api_request: ApiRequest,
    val metro_list: List<Metro>
)

data class Footer(
    val center: List<Any>,
    val left: List<Left>,
    val right: List<Any>
)

data class Header1(
    val center: List<Any>,
    val left: List<LeftX>,
    val right: List<Right>
)

data class ApiRequest(
    val params: Params,
    val url: String
)

data class Metro(
    val link: String,
    val metro_data: MetroData,
    val metro_id: Int,
    val position: String,
    val show_duration: Int,
    val style: Style,
    val tracking_data: TrackingData,
    val type: String
)

data class Params(
    val card: String,
    val card_index: Int,
    val extra: String,
    val last_item_id: Int,
    val material: String,
    val material_index: Int,
    val material_relative_index: Int,
    val num: Int,
    val recommend_index: Int,
    val section_id: Int,
    val start_last_item_id: Int,
    val type: String
)

data class MetroData(
    val album: List<Album>,
    val author: Author1,
    val cover: Cover1,
    val duration: Duration,
    val image_id: Int,
    val more: More,
    val play_ctrl: PlayCtrl,
    val play_url: String,
    val preview_url: String,
    val recommend_level: String,
    val resource_id: Int,
    val resource_type: String,
    val tags: List<Tag1>,
    val title: String,
    val top_tags: List<Any>,
    val video_id: Int
)

data class Style(
    val metro_to_screen_ratio: Double,
    val padding: Padding,
    val tpl_label: String
)

data class TrackingData(
    val click: List<Click>,
    val show: List<Show>
)

data class Album(
    val img_info: ImgInfo,
    val url: String
)

data class Author1(
    val avatar: Avatar,
    val description: String,
    val followed: Boolean,
    val link: String,
    val nick: String,
    val type: String,
    val uid: Int
)

data class Cover1(
    val img_info: ImgInfoXX,
    val url: String
)

data class Duration(
    val text: String,
    val value: Int
)

data class More(
    val enable_cache: Boolean,
    val enable_follow: Boolean,
    val share_platform: List<String>
)

data class PlayCtrl(
    val autoplay: Boolean,
    val autoplay_times: Int,
    val need_wifi: Boolean
)

data class Tag1(
    val id: Int,
    val link: String,
    val title: String
)

data class ImgInfo(
    val height: Int,
    val scale: Double,
    val width: Int
)

data class Avatar(
    val img_info: ImgInfoX,
    val url: String
)

data class ImgInfoX(
    val height: Int,
    val scale: Int,
    val width: Int
)

data class ImgInfoXX(
    val height: Int,
    val scale: Double,
    val width: Int
)

data class Padding(
    val bottom: Int,
    val left: Int,
    val right: Int,
    val top: Int
)

data class Click(
    val child: List<Child>,
    val `data`: DataXX,
    val sdk: String
)

data class Show(
    val `data`: DataXXX,
    val sdk: String
)

data class Child(
    val child: List<ChildX>,
    val `data`: DataX,
    val type: String
)

data class DataXX(
    val card_id: Int,
    val card_index: Int,
    val card_title: String,
    val card_type: String,
    val clickUrl: String,
    val click_action: String,
    val click_action_url: String,
    val dev_recommend_recall_type: String,
    val element_id: Int,
    val element_index: Int,
    val element_label: String,
    val element_title: String,
    val element_type: String,
    val monitorPositions: String,
    val needExtraParams: List<String>,
    val organization: String,
    val page_type: String,
    val playUrl: String,
    val relative_index: Int,
    val viewUrl: String
)

data class ChildX(
    val `data`: Data1,
    val type: String
)

data class DataX1(
    val card_id: Int,
    val card_index: Int,
    val card_title: String,
    val card_type: String,
    val click_action: String,
    val click_action_url: String,
    val click_name: String,
    val element_id: Int,
    val element_index: Int,
    val element_label: String,
    val element_title: String,
    val element_type: String,
    val relative_index: Int
)

data class Data1(
    val click_action: String,
    val click_name: String,
    val element_id: Int,
    val element_index: Int,
    val element_title: String,
    val element_type: String,
    val relative_index: Int
)

data class DataXXX(
    val card_id: Int,
    val card_index: Int,
    val card_title: String,
    val card_type: String,
    val clickUrl: String,
    val click_action_url: String,
    val dev_recommend_recall_type: String,
    val element_id: Int,
    val element_index: Int,
    val element_label: String,
    val element_title: String,
    val element_type: String,
    val monitorPositions: String,
    val needExtraParams: List<String>,
    val organization: String,
    val page_type: String,
    val playUrl: String,
    val relative_index: Int,
    val viewUrl: String
)

data class Left(
    val metro_data: MetroDataX,
    val metro_id: Int,
    val style: StyleX,
    val tracking_data: TrackingDataX,
    val type: String
)

data class MetroDataX(
    val avatar: AvatarX,
    val desc: String,
    val link: String,
    val nick: String
)

data class StyleX(
    val tpl_label: String
)

data class TrackingDataX(
    val click: List<ClickX>,
    val show: List<ShowX>
)

data class AvatarX(
    val img_info: ImgInfoXXX,
    val shape: String,
    val url: String
)

data class ImgInfoXXX(
    val height: Int,
    val scale: Int,
    val width: Int
)

data class ClickX(
    val `data`: DataXXXX,
    val sdk: String
)

data class ShowX(
    val `data`: DataXXXXX,
    val sdk: String
)

data class DataXXXX(
    val card_id: Int,
    val card_index: Int,
    val card_title: String,
    val card_type: String,
    val click_action: String,
    val click_action_url: String,
    val click_name: String,
    val page_type: String
)

data class DataXXXXX(
    val card_id: Int,
    val card_index: Int,
    val card_title: String,
    val card_type: String,
    val click_action_url: String,
    val page_type: String
)

data class LeftX(
    val metro_data: MetroDataXX,
    val metro_id: Int,
    val style: StyleXX,
    val tracking_data: TrackingDataXX,
    val type: String
)

data class Right(
    val metro_data: MetroDataXXX,
    val metro_id: Int,
    val style: StyleXXX,
    val tracking_data: TrackingDataXXX,
    val type: String
)

data class MetroDataXX(
    val text: String
)

data class StyleXX(
    val tpl_label: String
)

class TrackingDataXX(
)

data class MetroDataXXX(
    val link: String,
    val text: String
)

data class StyleXXX(
    val tpl_label: String
)

data class TrackingDataXXX(
    val click: List<ClickXX>,
    val show: List<ShowXX>
)

data class ClickXX(
    val `data`: DataXXXXXX,
    val sdk: String
)

data class ShowXX(
    val `data`: DataXXXXXXX,
    val sdk: String
)

data class DataXXXXXX(
    val card_id: Int,
    val card_index: Int,
    val card_title: String,
    val card_type: String,
    val click_action: String,
    val click_action_url: String,
    val click_name: String,
    val page_type: String
)

data class DataXXXXXXX(
    val card_id: Int,
    val card_index: Int,
    val card_title: String,
    val card_type: String,
    val page_type: String
)

data class PaddingX(
    val bottom: Int,
    val left: Int,
    val right: Int,
    val top: Int
)