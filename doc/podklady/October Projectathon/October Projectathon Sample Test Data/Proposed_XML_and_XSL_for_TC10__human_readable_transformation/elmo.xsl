<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:elmo="https://github.com/emrex-eu/elmo-schemas/tree/v1"
    exclude-result-prefixes="xs" 
    version="1.0">
    
    <xsl:output method="html"/>
    
    <xsl:template  match="/">
        <html>
            <head>
                <style>
                    table, th, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                    }
                </style>
            </head>
            <body>
                <h1>Educational evidence in ELMO format</h1>
                <xsl:apply-templates  select="descendant::elmo:learner" />
                <xsl:apply-templates  select="descendant::elmo:learningOpportunitySpecification" />
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="elmo:learner">
        <h2>Learner</h2>
        <table>
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>
            <tr>
            <xsl:for-each select="child::node()">
                <xsl:call-template name="printElasRow" />
            </xsl:for-each>    
            </tr>
        </table>
    </xsl:template>
    
    <xsl:template name="printElasRow">
        <tr>
            <td><xsl:value-of select="local-name(.)"/></td>
            <td><xsl:value-of select="text()"/></td></tr>
        
    </xsl:template>
    
    
    <xsl:template match="elmo:learningOpportunitySpecification">
        <h2>Learing opportunity</h2>
        <table>
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>
            <tr>
                <xsl:for-each select="child::node()">
                    <xsl:call-template name="printElasRow" />
                </xsl:for-each>    
            </tr>
        </table>
    </xsl:template>
    
</xsl:stylesheet>