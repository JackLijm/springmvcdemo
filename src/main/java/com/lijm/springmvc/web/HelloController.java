package com.lijm.springmvc.web;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class HelloController {
    @RequestMapping("/servlet/com.szicbc.direct1.servlet.DirectSeqServlet")
    public @ResponseBody String testIcbc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream inputStream = request.getInputStream();
        String result = IOUtils.toString(inputStream,"utf-8");
        System.out.println("收到客户端信息："+result);
        OutputStream outputStream = response.getOutputStream();
        String responseMsg = "<?xml version=\"1.0\" encoding = \"GBK\"?>" +
                "<CMS>" +
                "<eb>" +
                "<pub>" +
                "<TransCode>交易代码</TransCode>" +
                "<CIS>集团CIS号</CIS>" +
                "<BankCode>归属银行编号</BankCode>" +
                "<ID>证书ID</ID>" +
                "<TranDate>交易日期</TranDate>" +
                "<TranTime>交易时间</TranTime>" +
                "<fSeqno>指令包序列号</fSeqno>" +
                "<RetCode>交易返回码</RetCode>" +
                "<RetMsg>交易返回描述</RetMsg>" +
                "</pub>" +
                "<out>" +
                " <AccNo>账号</AccNo>" +
                "<AccName>户名</AccName>" +
                "<CurrType>币种</CurrType>" +
                "<BeginDate>起始日期</BeginDate>" +
                "<EndDate>截止日期</EndDate>" +
                "<MinAmt>发生额下限</MinAmt>" +
                "<MaxAmt>发生额上限</MaxAmt>" +
                "<BankType>行别</BankType>" +
                "<NextTag>查询下页标识</NextTag>" +
                "<TotalNum>交易条数</TotalNum>" +
                "<DueBillNo>借据编号</DueBillNo>" +
                "<AcctSeq>账号序号</AcctSeq>" +
                "<ComplementFlag>历史归档数据查询标志</ComplementFlag>" +
                "<rd>" +
                "   <Drcrf>借贷标志</Drcrf>" +
                "   <VouhNo>凭证号</VouhNo>" +
                "   <DebitAmount>借方发生额</DebitAmount>" +
                "<CreditAmount>贷方发生额</CreditAmount>" +
                "<Balance>余额</Balance>" +
                "    <RecipBkNo>对方行号</RecipBkNo>" +
                "<RecipBkName>对方行名</RecipBkName>" +
                "    <RecipAccNo>对方账号</RecipAccNo>" +
                "    <RecipName>对方户名</RecipName>" +
                "<Summary>摘要</Summary>" +
                " <UseCN>用途</UseCN>" +
                "    <PostScript>附言</PostScript>" +
                "<BusCode>业务代码</BusCode>" +
                "<Date>交易日期</Date>" +
                "<Time>时间戳</Time>" +
                "<Ref>业务编号</Ref>" +
                "    <Oref>相关业务编号</Oref>" +
                "    <EnSummary>英文备注</EnSummary>" +
                "<BusType>业务种类</BusType>" +
                "<VouhType>凭证种类</VouhType>" +
                "<AddInfo>附加信息</AddInfo>" +
                "<Toutfo>电子回单唯一标识</Toutfo>" +
                "<OnlySequence>银行交易流水号</OnlySequence>" +
                "<AgentAcctName>财务公司二级账户户名（资金池次要对手账号户名）</AgentAcctName>" +
                "<AgentAcctNo>财务公司二级账户账号（资金池次要对手账号）</AgentAcctNo>" +
                "<UpDtranf>冲正标志</UpDtranf>" +
                "<ValueDate>起息日</ValueDate>" +
                "<TrxCode>工行交易代码</TrxCode>" +
                "<Ref1>业务编号1</Ref1>" +
                "<Oref1>相关业务编号1</Oref1>" +
                "<CASHF>交易类型</CASHF>" +
                "<BusiDate>入账日期</BusiDate>" +
                "    <BusiTime>入账时间</BusiTime>" +
                "    <SeqNo>顺序号</SeqNo>" +
                "<MgNo>保证金编号</MgNo>" +
                "<MgAccNo>保证金缴存账号</MgAccNo>" +
                "<MgCurrType>保证金币种</MgCurrType>" +
                "<CashExf>钞汇标志</CashExf>" +
                "<DetailNo>明细序号</DetailNo>" +
                "<Remark>备注</Remark>" +
                "<TradeTime>交易时间</TradeTime>" +
                "<TradeFee>手续费</TradeFee>" +
                "<TradeLocation>交易场所</TradeLocation>" +
                "<ExRate>汇率</ExRate>" +
                "<ForCurrtype>外币币种</ForCurrtype>" +
                "<EnAbstract>英文摘要</EnAbstract>" +
                "<OpenBankNo>开户行行号</OpenBankNo>" +
                "<OpenBankBIC>开户行BIC</OpenBankBIC>" +
                "<OpenBankName>开户银行名称</OpenBankName>" +
                "<SubAcctSeq>账号序号</SubAcctSeq>" +
                "<THCurrency>币种</THCurrency>" +
                "<RecipBkName1>对方行名（以此为准）</RecipBkName1>" +
                "<RecipBkNo1>对方行号（以此为准）</RecipBkNo1>" +
                "<TInfoNew>电子回单唯一标识</TInfoNew>" +
                "<RefundMsg>跨行退回原因</RefundMsg>" +
                "<BusTypNo>回单业务种类</BusTypNo>" +
                "<ReceiptInfo>回单个性化信息</ReceiptInfo>" +
                "<TelNo>柜员号</TelNo>" +
                "             <MDCARDNO>本方财智账户卡卡号（管家卡卡号）</MDCARDNO>" +
                "<TrxAmt>交易金额</TrxAmt>" +
                "<TrxCurr>交易币种</TrxCurr>" +
                "</rd>" +
                "</out>" +
                "</eb>" +
                "</CMS>";
        responseMsg = "reqData="+ new BASE64Encoder().encode(responseMsg.getBytes());
        responseMsg = "errorCode="+ new BASE64Encoder().encode("21312321".getBytes());
        IOUtils.write(responseMsg.getBytes(),outputStream);
        outputStream.flush();
        return "";
    }
}
