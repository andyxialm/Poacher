# Poacher
聊天宝新闻阅读获取金币

> 聊天宝新闻阅读金币获取规则，目前发现的规律是在新闻列表/新闻详情页阅读持续约 30 秒左右触发获取金币。
持续 30 秒的说明：触发垂直方向滑动事件后，如果在 7 秒内没有继续触发垂直方向滑动事件，则停止计时，直至满一次 30 秒。
目前还不清楚获取金币数量的规则，目测滑动距离越长，模拟正常触发分页或者进入详情的次数能获取 10 金币，也碰到过 8 金币，4 金币的情况。
聊天宝阅读新闻获取金币有每日的最大值，超过最大值后阅读不再获得金币。

演示代码只简单实现了模拟滑动，仅提供方案，请不要真实使用在聊天宝中，有被封号的风险。